package com.rcmfootball.rcmfootball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcmfootball.rcmfootball.model.users.Users;
import com.rcmfootball.rcmfootball.repository.users.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersRepository usersRepository;
	@PostMapping("/create-account")
	public Users createNewAccount(@RequestBody Users user) {
		return usersRepository.save(user);
	}
	@GetMapping("/")
	public List<Users> findAllUsers(){
		return usersRepository.findAll();
	}
}
