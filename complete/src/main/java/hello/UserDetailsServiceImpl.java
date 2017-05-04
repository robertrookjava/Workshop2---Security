/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author robertrook
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    
    // even tijdelijk omdat @autowired niet schijnt te werken.
    //private UserFinder userFinder = new UserFinderImpl();
    
    // @Autowired doet het niet dus met new
    private UserFinder userFinder = new UserFinderImpl();
    
    //private User findByUserName (String username){
    //    if (username.equals("Robert Rook")){
    //        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    //        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    //        String password = "Ultimate Jazz";
    //        return new User(username,password,authorities); 
            
     //   }
     //   return null;
        
    //}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = this.findByUserName(username);
        User user = userFinder.findByUserName(username);
        if (user!=null){
            return user;
        }
        throw new UsernameNotFoundException(
                "User "+username+" not found"
        );
    }
    
    
}
