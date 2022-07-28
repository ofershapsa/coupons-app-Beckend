package com.CouponManagment.CouponManagment.serviceForJWT;

import java.util.Collection;
import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CustomerRepository;
import com.CouponManagment.CouponManagment.services.ClientType;
import com.CouponManagment.CouponManagment.config.JwtTokenUtil;
import com.CouponManagment.CouponManagment.model.Company;
import com.CouponManagment.CouponManagment.model.Customer;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private CompanyRepository cr;
	
	
	@Autowired
	private CustomerRepository cre;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Company  company = cr.findByCompanyName(username);
		Customer customer = cre.findByCustomerName(username);
		
		if (company == null) {
			if ("admin".equals(username)) {
				jwtTokenUtil.setClientType(ClientType.ADMIN);
				return new User("admin", "$2a$10$BtBNMih9qknsVbNx/5AtsONCleL4TVtVm5imMRjbqRtwTf1APJ8ta"
						+ "",
						getAuthorities(ClientType.ADMIN));
			} 
			if(customer!=null) {
				jwtTokenUtil.setClientType(ClientType.CUSTOMER);
				jwtTokenUtil.setId(customer.getId());
				return new org.springframework.security.core.userdetails.User(customer.getCustomerName(), customer.getPassword(),
						getAuthorities(ClientType.CUSTOMER));
			}
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		
		jwtTokenUtil.setClientType(ClientType.COMPANY);
		jwtTokenUtil.setId(company.getId());
		return new org.springframework.security.core.userdetails.User(company.getCompanyName(), company.getPassword(),
				getAuthorities(ClientType.COMPANY));
		
	}
	
	
	
	public Collection<? extends GrantedAuthority> getAuthorities(ClientType clientType) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			if(clientType.equals(ClientType.ADMIN)) {
				authorities.add( new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
			else if(clientType.equals(ClientType.COMPANY)) {
				authorities.add( new SimpleGrantedAuthority("ROLE_COMPANY"));
				}

			else if(clientType.equals(ClientType.CUSTOMER)) {
				authorities.add( new SimpleGrantedAuthority("ROLE_CUSTOMER"));
				}	
			System.out.println(authorities);		
			

		return authorities;
	}
	
	
	

}

