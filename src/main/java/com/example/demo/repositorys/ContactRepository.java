package com.example.demo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
  List<Contact> findAllByUserId(Integer userId);
}
