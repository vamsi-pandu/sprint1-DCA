package com.cg.dca.controllers;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.User;
import com.cg.dca.exception.InvalidUserException;
import com.cg.dca.repository.IUserRepository;
import com.cg.jwt.JwtTokenUtil;
import com.cg.jwt.LoginData;
import com.cg.jwt.TokenEntity;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	IUserRepository userRepository;

	User user;

	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginData data) throws Exception {

		Optional<User> userData = userRepository.findById(data.getUserId());

		if (userData.isPresent()) {
			user = userData.get();
		} else {
			throw new InvalidUserException("User not found with username: " + data.getUserId());
		}

		if (!(user.getPassword().equals(data.getPassword())))
			throw new InvalidUserException("Invalid Password");

		String token = jwtTokenUtil.generateToken(user);

		return ResponseEntity.ok(new TokenEntity(token));

	}

}