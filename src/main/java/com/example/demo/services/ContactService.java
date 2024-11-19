package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ContactDto;

public interface ContactService extends AbstractServices<ContactDto>{
  List<ContactDto> findAllByUserId (Integer UserId);
}
