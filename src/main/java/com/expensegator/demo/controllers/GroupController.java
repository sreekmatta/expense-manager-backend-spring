package com.expensegator.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.expensegator.demo.repositories.GroupRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GroupController {
	
	@Autowired
	GroupRepository groupRepository;

	public void createGroup() {
		
	}
	
	public void getGroupByID() {
		
	}
	
	public void updateGroup() {
		
	}
	
	public void deleteGroup() {
		
	}
}
