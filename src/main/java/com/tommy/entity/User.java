package com.tommy.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	private String sex;
	private String userId;
	private String address;
	private Integer post_no;
	private Integer age;
	private Boolean enabled;
	private Date birthday;
	private Date createDate;
	private Date updateDate;
	


	public User() {
	}

	public User( Long id, String username, String password, String email,
			String sex, String userId, String address, Integer post_no,
			Integer age, Boolean enabled, Date birthday,
			Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.userId = userId;
		this.address = address;
		this.post_no = post_no;
		this.age = age;
		this.enabled = enabled;
		this.birthday = birthday;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public  Long getId() {
		return id;
	}

	public void setId( Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPost_no() {
		return post_no;
	}

	public void setPost_no(Integer post_no) {
		this.post_no = post_no;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {

		try {
			this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			this.birthday=null;
		}

	}

	public String birthDateToString(){
		if(this.birthday!=null){
		 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String birthString=sdFormat.format(this.birthday);
		return birthString;
		}else{
			return null;
		}
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@PrePersist
	void preInsert() {
		this.createDate = new Date();
		this.enabled=false;
	}

	@PreUpdate
	void preUpdate() {
		updateDate = new Date();
	}
}
