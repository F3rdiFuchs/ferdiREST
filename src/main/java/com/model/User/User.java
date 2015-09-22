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
import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@JsonIgnore
	@Column(name = "password")
	private String passWord;
	
	@Column(name="state")
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "groupid")
	@JsonBackReference
	private Group group;
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void encryptPasswd() {
		int count = 0;
		while (count < PASSWORD_SECURITY)
		{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			this.passWord = passwordEncoder.encode(this.passWord);
			count++;
		}
	}
	
	@Override
	public String toString(){
		return this.userId.toString();
	}
}
