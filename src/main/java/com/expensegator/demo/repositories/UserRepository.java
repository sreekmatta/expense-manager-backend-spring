package com.expensegator.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.expensegator.demo.models.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer>{

}
