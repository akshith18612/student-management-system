package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Repo.userRepo;
import com.example.model.Userprincipal;
import com.example.model.Users;

@Service
public class MyUserDetails implements UserDetailsService {
   @Autowired
   private userRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Users user=userRepo.findByUsername(username);
      if(user==null){
        throw  new UsernameNotFoundException("user not found");
      } 
      return new Userprincipal(user);
    }
    
}
