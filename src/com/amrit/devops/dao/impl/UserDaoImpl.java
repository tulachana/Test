package com.tmobile.devops.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.tmobile.devops.dao.UserDAO;
import com.tmobile.devops.dto.CredentialsDTO;
import com.tmobile.devops.dto.UserInfoDTO;
import com.tmobile.devops.entity.User;
import com.tmobile.devops.entity.UserRole;


@Repository
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
    private PasswordEncoder passwordEncoder;

	////////////////////////////////////////////////////////////////////////////////////////
	//adds user during registration
	@Override
	public void addUser(User user) {
		// get the current hibernate session
	    Session currentSession = sessionFactory.getCurrentSession();
	    user.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
	    currentSession.save(user);
	   
	   
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	//this method checks if the login is successfull or not 
	//not used
	@Override
	public boolean checkLogin(String userName,String userPassword){
		boolean userFound = false;
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		String SQL_QUERY =" from User where userName=:userName and password=:password";
		Query<User> query = currentSession.createQuery(SQL_QUERY, User.class);
		query.setParameter("userName",userName);
		query.setParameter("password",userPassword);
		List<User> list = query.list();
		
		if ((list != null) && (list.size() > 0)) {
			System.out.println("Found the USer");
			userFound= true;
		}
		return userFound;  
	
	}
////////////////////////////////////////////////////////////////////////////
	//this method checks if the user exists or not during registration
	@Override
	public boolean checkUserExists(String username){
		boolean userFound = false;
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		String SQL_QUERY ="from User where username=:userName";
		Query<User> query = currentSession.createQuery(SQL_QUERY, User.class);
		query.setParameter("userName",username);

		List<User> list = query.list();
		
		if ((list != null) && (list.size() > 0)) {
			System.out.println("Found the USer");
			userFound= true;
		}
		return userFound;  
	
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	//this method lists all the users and their info  from the table 
	@Override
	public List<User> getUsers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//create a query
		Query<User> theQuery = currentSession.createQuery("from User order by firstName",User.class);
		
		//execute query and get results
		List<User> users = theQuery.getResultList();
		
		//return the results
		return users;

	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	///Gets all the roles from the roles table
	@Override
	public List<String> getUserRoles(String username) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//create a query
		String SQL_QUERY ="SELECT user_role FROM devops.user_roles where username=?";
		Query<String> theQuery = currentSession.createQuery(SQL_QUERY,String.class);
		//execute query and get results
		List<String> roles= theQuery.getResultList();
		
		return roles;
	}

	////////////////////////////////////////////////////////////////////////////
	//sets a given role to the user 
	@Override
	public void setUserRole(UserRole role, User user, String user_role) {
		// get the current hibernate session		
		Session currentSession = sessionFactory.getCurrentSession();
		
		role.setUser(user);
		role.setRole(user_role);
		currentSession.save(role);

	}
	
	///////////////////////////////////////////////////////////////////////////////////
	///Check if the a user with certain username exists or not in the table
	@Override
	public User findByUserName(String userName) {
		List<User> userList = new ArrayList<User>();
		// get the current hibernate session		
		Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where userName=:userName",User.class);
        query.setParameter("userName", userName);
        userList = query.list();
        if (userList.size() > 0){
        	System.out.println("The user list found is " + userList);
            return userList.get(0);
        }else{
            return null;    
        }
	}
	
	@Override
	public User getUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		//retrieve customer with the id
		User user = currentSession.get(User.class,username);
		return user;
	}
	
	
	@Override
	public void updateUser(UserInfoDTO user) {
		// get the current hibernate session
	    Session session = sessionFactory.getCurrentSession();
	    System.out.println("THe username is from impl " + user.getUserName());
	   session.update(user);  
	}
	
	@Override
	public void changePassword(CredentialsDTO user) {
		// get the current hibernate session
	    Session session = sessionFactory.getCurrentSession();
	    System.out.println("THe username is from impl " + user.getUserName());
	    user.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
	   session.update(user);  
	}
	
	@Override
	public void deleteUser(String username) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("The username to delete is " + username);			
	
		@SuppressWarnings("unchecked")
		Query <User> theQuery = currentSession.createQuery("from User where userName=:userName");
		theQuery.setParameter("userName", username);
		User user= (User)theQuery.list().get(0);
		currentSession.delete(user);
		
	
	}
	
	
	
}
