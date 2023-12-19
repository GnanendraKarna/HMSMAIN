package com.hospital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.User;
import com.hospital.payload.request.LoginRequest;
import com.hospital.payload.request.SignupRequest;
import com.hospital.payload.request.UpdateRequest;
import com.hospital.payload.response.AuthenticationResponse;
import com.hospital.services.impl.AuthenticationServiceImpl;
import com.hospital.services.impl.UserService;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins="http://localhost:4200/")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationServiceImpl service;
	
	private Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register( @RequestBody SignupRequest request){
		return new ResponseEntity<>(service.register(request), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
		return new ResponseEntity<>(service.authenticate(request), HttpStatus.OK);
	}
	
	@PutMapping("/logout/{id}")
	public ResponseEntity<?> signout(@PathVariable Integer id){
		return new ResponseEntity<>(service.signout(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deletebyId(@PathVariable Integer id){
		return new ResponseEntity<>(service.deletebyid(id), HttpStatus.OK);
	}
	
	@PutMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody LoginRequest request){
		return new ResponseEntity<>(service.changePassword(request), HttpStatus.OK);
	}
	
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("/updateprofile/{id}")
	public ResponseEntity<?> updateProfile(@PathVariable Integer id, @RequestBody UpdateRequest user){
		return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
	}

	@GetMapping("/user/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserDetails(email), HttpStatus.OK);
    }
}

