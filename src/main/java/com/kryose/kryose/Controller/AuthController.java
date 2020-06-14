package com.kryose.kryose.Controller;


import com.kryose.kryose.Entity.AuthRequest;
import com.kryose.kryose.Entity.AuthResponse;
import com.kryose.kryose.Entity.CrmUser;
import com.kryose.kryose.Entity.User;
import com.kryose.kryose.Repository.UserRepo;
import com.kryose.kryose.Service.UserServiceImpl;
import com.kryose.kryose.Util.JwtUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class AuthController {

    Logger logger=LoggerFactory.getLogger(AuthController.class);

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepo myUserRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    @RequestMapping("/")
    public String home(){

        return "home";
    }

    @PostMapping("/register")
    public String Register(@RequestBody CrmUser theCrmUser){
        String userName = theCrmUser.getUserName();
        logger.error(String.valueOf(theCrmUser));
        if(userService.findByUserName(userName) !=null){
            return "user already exists";
        }else{
            logger.error("calling userService.save method");
            userService.save(theCrmUser);
        }


            return "registration-confirmation";

    }
    @PostMapping("/delete")
    public String Delete(@RequestBody CrmUser theCrmUser){
        String userName = theCrmUser.getUserName();
        userService.deleteUserByUsername(userName);

        return "registration-confirmation";

    }

    @GetMapping("/getuser")
    public User getUser(){

        User existing = userService.findByUserName("saurabh");
        logger.error("Hi ");
        return existing;

    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
