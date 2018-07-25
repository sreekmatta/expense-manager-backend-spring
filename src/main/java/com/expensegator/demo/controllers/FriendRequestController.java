package com.expensegator.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensegator.demo.models.FriendRequest;
import com.expensegator.demo.models.User;
import com.expensegator.demo.repositories.FriendRequestRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FriendRequestController {

	@Autowired
	FriendRequestRepository friendRequestRepository;
	
	@PostMapping("/api/friend/request")
	public ResponseEntity<HttpStatus> createFriendRequest(@RequestBody FriendRequest friendRequest, HttpSession session) {
		FriendRequest savedFriendRequest = friendRequestRepository.save(friendRequest);
		if (savedFriendRequest != null) {
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/api/friend/send/request/{id}")
	public List<FriendRequest> findSendRequestsById(@PathVariable int id) {
		User senderUser = new User();
		senderUser.setId(id);
		return friendRequestRepository.findSendRequestsById(senderUser);
	}

}
