package com.tmobile.devops.service.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tmobile.devops.dao.UserDAO;
import com.tmobile.devops.dto.CredentialsDTO;
import com.tmobile.devops.dto.UserInfoDTO;
import com.tmobile.devops.entity.User;
import com.tmobile.devops.entity.UserRole;
import com.tmobile.devops.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO theUserDAO;

	@Override
	@Transactional
	public void addUser(User theUser) {
		// TODO Auto-generated method stub
       theUserDAO.addUser(theUser);
	}

	@Override
	@Transactional
	public boolean checkLogin(String userName, String userPassword) {
		return theUserDAO.checkLogin(userName, userPassword);
	}
	@Override
	@Transactional
	public boolean checkUserExists(String username) {
		return theUserDAO.checkUserExists(username);
	}
	
	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return theUserDAO.getUsers();
	}

	@Override
	@Transactional
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return theUserDAO.findByUserName(username);
	}

	@Override
	@Transactional
	public void setUserRole(UserRole role , User user, String user_role) {
		// TODO Auto-generated method stub
       theUserDAO.setUserRole(role, user, user_role);;
	}

	@Override
	@Transactional
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return theUserDAO.getUser(username);
	}

	@Override
	@Transactional
	public void updateUser(UserInfoDTO user) {
		theUserDAO.updateUser(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(String username) {
		theUserDAO.deleteUser(username);
		
	}

	@Override
	@Transactional
	public void changePassword(CredentialsDTO username) {
		// TODO Auto-generated method stub
		theUserDAO.changePassword(username);
		
	}



	




}
