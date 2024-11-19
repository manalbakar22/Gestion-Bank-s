package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
