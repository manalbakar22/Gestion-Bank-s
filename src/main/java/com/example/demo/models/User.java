package com.example.demo.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="_user")

public class User extends AbstractEntity{
	
	
	
	
	private String firsname;
	private String lastname;
	private String email;
	private String password;
	private boolean Active;
	
	@OneToOne
	private Adress adress;
	
	@OneToMany(mappedBy = "user")
	private List<Transaction> transactions ;
	
	@OneToMany(mappedBy = "user")
	private List<Contact> contacts;
	
	@OneToOne
	private Account account;
	
	@OneToOne
	private Role role;
}
