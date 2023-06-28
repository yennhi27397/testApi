package com.app.identity;

import org.springframework.security.core.authority.AuthorityUtils;
import com.app.model.user.Users;

public class TokenUser extends org.springframework.security.core.userdetails.User {
    private Users user;

    //For returning a normal user
    public TokenUser(Users user) {
        super( user.getUserId(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()  )  );
        //super(user.getUserName(), user.getPassword(), true, true, true, true,  AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public String getRole() {
        return user.getRole().toString();
    }
}
