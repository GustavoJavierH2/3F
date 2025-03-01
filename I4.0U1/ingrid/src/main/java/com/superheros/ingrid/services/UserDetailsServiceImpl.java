package com.superheros.ingrid.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.superheros.ingrid.entity.UserEntity;
import com.superheros.ingrid.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

    @Autowired 
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        UserEntity userEntity = this.userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        
        
       return new User(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
    }

}
