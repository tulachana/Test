package com.tmobile.devops.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class CredentialsDTO {

	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
