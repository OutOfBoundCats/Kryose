package com.kryose.kryose.Service;

import com.kryose.kryose.Controller.AuthController;
import com.kryose.kryose.Dao.RoleDao;
import com.kryose.kryose.Dao.UserDao;
import com.kryose.kryose.Entity.*;
import com.kryose.kryose.Repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // need to inject user dao
    Logger logger= LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo myUserRepo;


    @Override
    @Transactional
    public User findByUserName(String userName) {
        // check the database if the user already exists
        logger.error("in findUserByUserName");
        return userDao.findUserByUsername(userName);
    }

    @Transactional
    public User deleteUserByUsername(String userName) {
        // check the database if the user already exists
        logger.error("in deleteUserByUserName");
        return userDao.deleteUser(userName);
    }


    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
        MyUserDetails myUSerDetails;
        Resource myResource;
        // assign user details to the user object
        user.setUserName(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());

        // give user default role of "employee"
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_ADMIN")));
        //set MyUserDetails
        myUSerDetails=new MyUserDetails(crmUser.getUserName());
        logger.error(String.valueOf(myUSerDetails));
        user.setMyUserDetauilsID(myUSerDetails);
        myUSerDetails.setMyuser(user);

        //set Resource Details
        myResource=new Resource( Long.valueOf(0),crmUser.getUserName(),null,null,"Welcome",Long.valueOf(0),Long.valueOf(0),Long.valueOf(0));
        myUSerDetails.setMyResource(myResource);


        logger.error("calling DAO save method");
        // save user in the database
        userDao.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
