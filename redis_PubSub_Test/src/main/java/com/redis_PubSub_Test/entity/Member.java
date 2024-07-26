package com.redis_PubSub_Test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String id;
	private String firstName;
	private String lastName;
	private Address addr;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public Member() {
		super();
	}
	public Member(String id, String firstName, String lastName, Address addr) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addr=" + addr.toString() + "]";
	}
	
	
	
}
