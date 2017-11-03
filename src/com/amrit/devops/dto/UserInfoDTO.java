package com.tmobile.devops.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.tmobile.devops.validation.ValidEmail;

@Entity
@Table(name="users")
public class UserInfoDTO {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    
	@NotBlank
	@NotNull(message="is Required")
	@Size(min=1,max=10)
	@Column(name="firstName")
	private String firstName;
	
	@NotNull(message="is Required")
	@Size(min=1,message="is Required")
	@Column(name="lastName")
	private String lastName;
	
	@NotNull(message="is Required")
	@Size(min=1,message="is Required")
	@ValidEmail(message="Email is not Valid")
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Id
	@NotNull(message="is Required")
	@Size(min=3,max=10,message="Minimum three letters required")
	@Column(name="username")
	private String userName;

	public UserInfoDTO(){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
