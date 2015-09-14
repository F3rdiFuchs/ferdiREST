package com.model.User;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.Groups.Groups;

@Entity
@Table(name="user")
public class User extends ResourceSupport {
	private static final int PASSWORD_SECURITY = 2;
	
	@Id
    @GeneratedValue
    @Column(name="userid")
	private Integer userId;
	
	@NotNull
	@Size(min=5, max=15, message="Must be between 5 and 15 letters")
	@Column(name="username")
	private String userName;
	
	@Size(max=15, message="max 15 chars")
	@Column(name="name")
	private String name;
	
	@Size(max=15,message="max 15 chars")
	@Column(name="lastname")
	private String lastName;
	
	@NotEmpty(message = "Please enter your email addresss.")
	@Size(max=45)
	@Email
	@Column(name="email")
	private String eMail;

	@JsonIgnore
	@NotEmpty(message = "Please enter your password")
	@Size(max=150)
	@Column(name="password")
	private String passWord;
	
	@ManyToOne
	@JoinColumn(name="groupid")
	@JsonBackReference
	private Groups groups;
	
	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void encryptPasswd() {
		int count = 0;
		while(count < PASSWORD_SECURITY)
		{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			this.passWord = passwordEncoder.encode(this.passWord);
			count++;
		}
	}
	
	@Override
	public String toString()
	{
		return this.userId.toString();
	}
}
