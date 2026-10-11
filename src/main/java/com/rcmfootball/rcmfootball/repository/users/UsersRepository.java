package com.rcmfootball.rcmfootball.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcmfootball.rcmfootball.model.users.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByUsername(String username);
}
