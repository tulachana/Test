package com.tmobile.devops.service;

import java.util.List;

import com.tmobile.devops.dto.CredentialsDTO;
import com.tmobile.devops.dto.UserInfoDTO;
import com.tmobile.devops.entity.User;
import com.tmobile.devops.entity.UserRole;

public interface UserService {
  public void addUser(User theUser);
  public boolean checkLogin(String userName, String userPassword);
  boolean checkUserExists(String username);
  public List<User> getUsers();
  

  public User findUser(String username);

void setUserRole(UserRole role, User user, String user_role);
public User getUser(String username);

void updateUser(UserInfoDTO user);
public void deleteUser(String username);

void changePassword(CredentialsDTO username);

}
