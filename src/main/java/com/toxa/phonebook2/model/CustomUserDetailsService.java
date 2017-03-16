package com.toxa.phonebook2.model;

import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.entity.Enums.UserRoleEnum;
import com.toxa.phonebook2.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getUser(login);

        if(user==null){
            System.out.println("User not found " + login);
            throw new UsernameNotFoundException("Username not found " + login);
        }

        System.out.println("User login : " + user.getLogin());

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                getGrantedAuthorities());
    }

    private List<GrantedAuthority> getGrantedAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(UserRoleEnum.USER.getUserRoleType()));
        System.out.println("authorities : " + authorities);
        return authorities;
    }
}
