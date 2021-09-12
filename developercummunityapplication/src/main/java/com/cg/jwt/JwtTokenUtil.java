package com.cg.jwt;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Admin;
import com.cg.dca.entity.User;
import com.cg.dca.exception.InvalidTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public class JwtTokenUtil implements Serializable {

	public static final long JWT_TOKEN_VALIDITY = 3 * 60 * 60 *1000;   // 3 hours

	@Value("${jwt.secret}")
	private String secretKey;
	
	public String generateAdminToken(Admin admin) {

		Claims claims = Jwts.claims();
//		claims.setSubject(Integer. admin.getAdminId());
		claims.put("role", "admin");

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS512 ,secretKey)
				.compact();
	}
	// generate token for user
	public String generateUserToken(User user) {

		Claims claims = Jwts.claims();
		claims.setSubject(user.getUserId());
		claims.put("role", "user");

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS512 ,secretKey)
				.compact();
	}

	// validate and extract User details from header
	public String validateTokenAndGetUserDetails(HttpServletRequest request) {
		final String tokenHeader = request.getHeader("Authorization");

		String token = null;

		if (tokenHeader == null)
			throw new InvalidTokenException("User Not Logged In or token not included");
		
		// JWT Token is in the form "Bearer token". Remove Bearer word
		if (!tokenHeader.startsWith("Bearer "))
			throw new InvalidTokenException("Invalid Token");

		token = tokenHeader.substring(7);
		
		try {
			Claims claims =Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
			//User user = new User();
			//user.setUserId(claims.getSubject());
			System.out.println(claims.getExpiration());
			return (String)claims.get("role");
		} catch (SignatureException ex) {
			throw new InvalidTokenException("Token Signature not valid");
			
		} catch (ExpiredJwtException ex) {
			throw new InvalidTokenException("Token expired. Login again");
		}
		catch (IllegalArgumentException | MalformedJwtException ex) {
			throw new InvalidTokenException("Token is invalid");
		}
	
	}
}