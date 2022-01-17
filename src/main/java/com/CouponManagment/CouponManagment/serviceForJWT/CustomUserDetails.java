package com.CouponManagment.CouponManagment.serviceForJWT;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetails implements UserDetails {

	   
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    
    //    private User user;
		private Long id;
        
	    private String username;

	    private String password;

	    private boolean accountNonExpired;

	    private boolean accountNonLocked;

	    private boolean credentialsNonExpired;

	    private boolean enabled;

	    

	   
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    @Override
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return accountNonExpired;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return accountNonLocked;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return credentialsNonExpired;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	   

	    @Override
	    public List<GrantedAuthority> getAuthorities(){
	        
	        return null;
	    }

}
