package com.example.demo.Implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AdressDto;
import com.example.demo.models.Adress;
import com.example.demo.repositorys.AdressRepository;
import com.example.demo.services.AdressService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor


public class AdressServiceImpl implements AdressService{
	private final AdressRepository adressRepository;

	@Override
	public Integer save(AdressDto Dto) {
		Adress adress = AdressDto.toAdressEntity(Dto);
		
		return adressRepository.save(adress).getId() ;
	}

	@Override
	public List<AdressDto> findAll() {
		
		return adressRepository.findAll()
				.stream()
				.map(AdressDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public AdressDto findById(Integer id) {
       return  adressRepository.findById(id)
				
				.map(AdressDto:: fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No user i found with the provided id : :" +id));
	
	}

	@Override
	public void delleteById(Integer id) {
		adressRepository.deleteById(id);
		
	}

}
