package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.Message;
import com.login.entity.UserInfo;
import com.login.service.JWTService;
import com.login.service.LoginService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	JWTService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@GetMapping("/hello")
	public UserInfo sayHelloMethod() {
		System.out.println("sayHelloMethod is called ..............");
		return new UserInfo();
	}

	@PostMapping("/register")
	public Message addNewUser(@RequestBody UserInfo userInfo) {
		return loginService.addUser(userInfo);
	}

	@GetMapping("/all")
	public List<UserInfo> listAllUsers() {
		List<UserInfo> list = loginService.listAllUsers();
		return list;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<Message> authenticateAndGetToken(@RequestBody UserInfo userInfo) {

		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userInfo.getName(), userInfo.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			return new ResponseEntity((new Message("Invalid Username or Passsword")), HttpStatus.OK);
		}

		return new ResponseEntity((new Message(jwtService.generateToken(userInfo.getName()))), HttpStatus.OK);
		
		//return new Message(jwtService.generateToken(userInfo.getName()).toString());

	}
}
