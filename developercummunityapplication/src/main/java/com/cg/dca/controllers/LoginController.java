package com.cg.dca.controllers;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.Admin;
import com.cg.dca.entity.User;
import com.cg.dca.exception.InvalidUserException;
import com.cg.dca.repository.IAdminRepository;
import com.cg.dca.repository.IUserRepository;
import com.cg.jwt.JwtTokenUtil;
import com.cg.jwt.TokenEntity;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	private IAdminRepository adminRepository;

	//User user;

	@Value("${jwt.secret}")
	private String secretKey;
	
	@PostMapping("/admin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Admin admin) throws Exception {

		//Optional<User> userData = userRepository.findById(data.getUserId());

		Admin admin1;
		Optional<Admin> adminData = adminRepository.findById(admin.getAdminId());
		if (adminData.isPresent()) {
			admin1 = adminData.get();
		} else {
			throw new InvalidUserException("Admin not found with ID: " + admin.getAdminId());
		}

		if (!(admin1.getAdPassword().equals(admin.getAdPassword())))
			throw new InvalidUserException("Invalid Password");

		String token = jwtTokenUtil.generateAdminToken(admin1);

		return ResponseEntity.ok(new TokenEntity(token));

	}
	@PostMapping("/user")
	public ResponseEntity<?> createClientAuthenticationToken(@RequestBody User user) throws Exception {

//		Optional<User> userData = userRepository.findById(data.getUsername());

		User user1;
		
		Optional<User> userData = userRepository.findById(user.getUserId());
		if (userData.isPresent()) {
			user1 = userData.get();
		} else {
			throw new InvalidUserException("User not found with ID: " + user.getUserId());
		}

		if (!(user1.getPassword().equals(user.getPassword())))
			throw new InvalidUserException("Invalid Password");

		String token = jwtTokenUtil.generateUserToken(user1);
		
//		System.out.println("----------------------------------------------------------");
//		System.out.println(token);
//		System.out.println("---------------------------------------------------------");
//		Claims claims =Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//		System.out.println(claims.get("role"));

		return ResponseEntity.ok(new TokenEntity(token));

	}
	
	
	

}