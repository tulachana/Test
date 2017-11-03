package com.tmobile.devops.service.impl;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmobile.devops.dao.UserDAO;
import com.tmobile.devops.entity.User;
import com.tmobile.devops.entity.UserRole;

@Service
@Transactional(readOnly=true)
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UserDAO userDAO;
	

	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		User user = userDAO.findByUserName(username);
		//UserRole role = userDAO.findRolesByUserName(username);
		//System.out.println("The role from the user is " + role.getRole());
		System.out.println("User to search for is " + username);
		if ( user!=null){
			System.out.println("the user from username " + user.toString());
			System.out.println("The user service role is " + user.getUserRole());
		
			
			List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

            return new org.springframework.security.core.userdetails.User(username, user.getEncryptedPassword(), user.isEnabled(), true, true, true, authorities);
			
			
		}else{
			throw new UsernameNotFoundException("User Not Found!!!");
		
		}
	}
		

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		List <GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		// Build user's authorities
		try{
			for (UserRole userRole : userRoles){
				authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRole()));
			}
		}catch(Exception ex) {
            System.out.println(ex.toString());
        }

		 System.out.println("THe role is " + authorities);
		return authorities;
	}

	

}
