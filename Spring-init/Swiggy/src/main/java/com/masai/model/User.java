package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(unique = true)
	private String username;
	@NotNull(message="password can not be null") 
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@NotNull(message="Role can not be null")
	private String role;
	public User(String username, @NotNull(message = "password can not be null") String password,
			@NotNull(message = "Role can not be null") String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	

}
