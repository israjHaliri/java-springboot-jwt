package com.haliri.israj.notebookservice.config;


import com.haliri.israj.notebookservice.domain.Role;
import com.haliri.israj.notebookservice.domain.User;
import com.haliri.israj.notebookservice.service.UserService;

import com.haliri.israj.notebookservice.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by israjhaliri on 8/25/17.
 */

@Service
public class UserDetailsConfig implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userService.findByUsername(username);
        AppUtils.getLogger(this).info("USERNAME PARAMETER : {}, DETAIL : {}",username, user.toString());
        if (user.getUsername() == null) {
            throw new UsernameNotFoundException(username);
        } else {

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Role roles : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
            }

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
    }
}