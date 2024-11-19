package com.example.demo.Implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.ContactDto;
import com.example.demo.models.Contact;
import com.example.demo.repositorys.AccountRepository;
import com.example.demo.repositorys.ContactRepository;
import com.example.demo.services.ContactService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class ContactServioceImpl implements ContactService {
	private final ContactRepository contactRepository;

	@Override
	public Integer save(ContactDto Dto) {
		Contact contact = ContactDto.toEntity(Dto);
		return contactRepository.save(contact).getId();
		
		
	}

	@Override
	public List<ContactDto> findAll() {
		
		return contactRepository.findAll()
				.stream()
				.map(ContactDto :: fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public ContactDto findById(Integer id) {
       return  contactRepository.findById(id)
				
				.map(ContactDto :: fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No user i found with the provided id : :" +id));
	
	}
	

	@Override
	public void delleteById(Integer id) {
		contactRepository.deleteById(id);
		
	}
	@Override
	  public List<ContactDto> findAllByUserId(Integer userId) {
	    return contactRepository.findAllByUserId(userId)
	        .stream()
	        .map(ContactDto::fromEntity)
	        .collect(Collectors.toList());
	  }
	

}
