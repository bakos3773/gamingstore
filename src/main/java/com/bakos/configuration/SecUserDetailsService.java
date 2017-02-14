package com.bakos.configuration;


import com.bakos.model.User;
import com.bakos.services.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecUserDetailsService implements UserDetailsService {

    @Autowired
    UserSearchService userSearchService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userSearchService.findByName(username);

         if(user!=null && user.isConfirmationStatus()){
            UserDetails details = new SecUserDetails(user);
            return details;
        }else{
            throw new UsernameNotFoundException(username);
        }

    }
}
