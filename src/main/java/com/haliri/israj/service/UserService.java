package com.haliri.israj.service;

import com.haliri.israj.domain.Role;
import com.haliri.israj.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by israjhaliri on 8/28/17.
 */
@Service
public class UserService {

    public User findByUsername(String username){
        if(!username.equals("israjhaliri")){
            return  new User();
        }
        User user = new User();
        user.setId(1L);
        user.setEmail("israj.haliri@gmail.com");
        user.setUsername("israjhaliri");
        user.setPassword("$2a$10$i1r3wh0WnFum1d39GFwzfeN9.VIwjJW1ma6l3KvXdD7nocWsAtKf.");

        Role role = new Role();
        role.setId(1L);
        role.setRole("ADM");
        role.setRoleName("ROLE_ADM");

        Set<Role> roleSet =  new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);

        return user;
    }
}
