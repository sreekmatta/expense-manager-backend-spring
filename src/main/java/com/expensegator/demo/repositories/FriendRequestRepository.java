package com.expensegator.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.expensegator.demo.models.FriendRequest;

@Service
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer>{
}
