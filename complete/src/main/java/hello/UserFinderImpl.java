/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author robertrook
 */
@Component
public class UserFinderImpl implements UserFinder {

    @Override
    public User findByUserName (String username){
        if (username.equals("Robert Rook")){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            String password = "Ultimate Jazz";
            System.out.println("Hallo in FindByUserName, User gevonden");
            return new User(username,password,authorities); 
            
        }
        return null;
        
    }
    
}
