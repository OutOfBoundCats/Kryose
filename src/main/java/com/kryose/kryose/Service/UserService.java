package com.kryose.kryose.Service;

import com.kryose.kryose.Entity.In_Out.CrmUser;
import com.kryose.kryose.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
