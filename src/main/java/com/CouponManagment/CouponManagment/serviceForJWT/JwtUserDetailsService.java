package com.CouponManagment.CouponManagment.serviceForJWT;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CustomerReposiroty;
import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Customer;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	//private UserDao userDao;
	private CompanyRepository cr;
	
	
	@Autowired
	private CustomerReposiroty cre;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//DAOUser user = userDao.findByUsername(username);
		Company  company = cr.findByCompanyName(username);
		Customer customer = cre.findByCustomerName(username);
		
		if (company == null) {
			if ("admin".equals(username)) {
				return new User("admin", "$2a$10$BtBNMih9qknsVbNx/5AtsONCleL4TVtVm5imMRjbqRtwTf1APJ8ta"
						+ "",
						new ArrayList<>());
			} 
			if(customer!=null) {
				return new org.springframework.security.core.userdetails.User(customer.getCustomerName(), customer.getPassword(),
						new ArrayList<>());
			}
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		
		
		return new org.springframework.security.core.userdetails.User(company.getCompanyName(), company.getPassword(),
				new ArrayList<>());
		
	}

}
