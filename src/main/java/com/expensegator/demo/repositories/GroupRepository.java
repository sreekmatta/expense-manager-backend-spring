package com.expensegator.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensegator.demo.models.Group;

public interface GroupRepository extends JpaRepository<Group, Integer>{

}
