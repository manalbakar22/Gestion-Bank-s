package com.example.demo.dto;

import com.example.demo.models.Contact;
import com.example.demo.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class ContactDto {
	
	private Integer id;
	private String firsname;
	private String lastname;
	private String email;
	private String iban;
	private Integer userId;
	
	
	public static ContactDto fromEntity(Contact contact) {
		return ContactDto.builder()
		.id(contact.getId())
		.firsname(contact.getFirsname())
		.email(contact.getEmail())
		.iban(contact.getIban())
		.userId(contact.getUser().getId())
		.build();
	}
	
	public static Contact toEntity(ContactDto contact) {
		return Contact.builder()
		.id(contact.getId())
		.firsname(contact.getFirsname())
		.email(contact.getEmail())
		.iban(contact.getIban())
		 .user(
	    		  User.builder()
	    		      .id(contact.getUserId())
	    		    		  .build()
	    		  )
		.build();
	}
	

}
