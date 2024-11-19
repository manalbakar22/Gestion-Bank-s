package com.example.demo.Controlleurs;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdressDto;
import com.example.demo.services.AdressService;

import lombok.RequiredArgsConstructor;

@RestController
	@RequestMapping("/adresses")
	@RequiredArgsConstructor
	@Tag(name = "address")
	public class AddressController {

	  private final AdressService service;

	  @PostMapping("/")
	  public ResponseEntity<Integer> save(
	      @RequestBody AdressDto addressDto
	  ) {
	    return ResponseEntity.ok(service.save(addressDto));
	  }

	  @GetMapping("/")
	  public ResponseEntity<List<AdressDto>> findAll() {
	    return ResponseEntity.ok(service.findAll());
	  }

	  @GetMapping("/{address-id}")
	  public ResponseEntity<AdressDto> findById(
	      @PathVariable("address-id") Integer addressId
	  ) {
	    return ResponseEntity.ok(service.findById(addressId));
	  }

	  @DeleteMapping("/{address-id}")
	  public ResponseEntity<Void> delete(
	      @PathVariable("address-id") Integer addressId
	  ) {
	    service.delete(addressId);
	    return ResponseEntity.accepted().build();
	  }
	}

