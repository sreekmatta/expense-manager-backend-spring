package com.expensegator.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.expensegator.demo.models.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT p FROM User p WHERE p.email = :email and p.password = :password")
	public List<User> findUserByCredentials(@Param("email") String email, @Param("password") String password);
	
}
