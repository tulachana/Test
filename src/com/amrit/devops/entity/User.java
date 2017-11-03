package com.tmobile.devops.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;


import com.tmobile.devops.validation.ValidEmail;

@Entity
@Table(name="users")
@DynamicUpdate
public class User implements Serializable {
	
	//@Id
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
	@ValidEmail(message="Provide a valid Email Format")
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Id
	@NotNull(message="is Required")
	@Size(min=3,max=10,message="Minimum three letters required")
	@Column(name="username")
	private String userName;
	
	@Transient
	@NotNull(message="is Required")
	@Size(min=1,max=10,message="Min is 1 and max i 10")
	private String password;
	
	
	@Column(name="password")
	private String encryptedPassword;
	
	@NotNull(message="is Required")
	@Transient
	private String confirmPassword;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="addedTime")
    private Date dateTime;
	
	@Column(name="enabled")
	private boolean enabled = true;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")	
	@Cascade(org.hibernate.annotations.CascadeType.DELETE) 
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	 


	public User() {
		// TODO Auto-generated constructor stub
	}


	
	//getter and setter
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isEnabled(){
		return enabled;
	}
	public void setEnabled (boolean enabled){
		this.enabled = enabled;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}


	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	

}
