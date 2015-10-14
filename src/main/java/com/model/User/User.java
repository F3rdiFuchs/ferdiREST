package com.model.User;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.model.Group.Group;

@Entity
@Table(name = "user")
public class User extends ResourceSupport {
	private static final int PASSWORD_SECURITY = 2;
	
	@Id
    @GeneratedValue
    @Column(name = "userid")
	private Integer userId;
	
	@NotNull
	@Column(name = "username")
	private String userName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Email
	@Column(name = "email")
	private String eMail;

	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "groupid")
	@JsonBackReference
	private Group groups;
	
	public Group getGroups() {
		return groups;
	}

	public void setGroups(Group groups) {
		this.groups = groups;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void encryptPasswd() {
		int count = 0;
		while (count < PASSWORD_SECURITY)
		{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			this.password = passwordEncoder.encode(this.password);
			count++;
		}
	}
	
	@Override
	public String toString(){
		return this.userId.toString();
	}
}
