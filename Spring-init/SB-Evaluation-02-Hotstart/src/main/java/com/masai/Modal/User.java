package com.masai.Modal;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
 * userId (unique identifier)
name
email
contentToStream (TreeSet of content objects)
 */
public class User {

	private int userId;
	private String name;
	private String email;
	private Set<Content> contentSet = new HashSet<>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String name, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Content> getContentSet() {
		return contentSet;
	}
	public void setContentSet(Set<Content> contentSet) {
		this.contentSet = contentSet;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(contentSet, email, name, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contentSet, other.contentSet) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
