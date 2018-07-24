package com.expensegator.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.expensegator.demo.models.FriendRequest;

@Service
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer>{
	
	@Query("SELECT f FROM friend_request f WHERE f.sent_from_id like :senderId")
	public List<FriendRequest> findSendRequestsById(@Param("senderId") int senderId);
}
