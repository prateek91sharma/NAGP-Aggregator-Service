package com.local.microservices.NAGPAggregatorService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long userId;	

private String name;

private int age;

private String email;

public User() {
	super();
}

public User(String name, int age, String email) {
	super();
	this.name = name;
	this.age = age;
	this.email = email;
}

public long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
