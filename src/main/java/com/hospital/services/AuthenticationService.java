package com.hospital.services;

import com.hospital.entities.User;
import com.hospital.payload.request.LoginRequest;
import com.hospital.payload.request.SignupRequest;
import com.hospital.payload.response.AuthenticationResponse;

public interface AuthenticationService {

	AuthenticationResponse register(SignupRequest request);

	AuthenticationResponse authenticate(LoginRequest request);

	User changePassword(LoginRequest request);

	User getUserById(int id);

	boolean deletebyid(Integer id);

	boolean signout(int id);

	User getUserDetails(String email);
}
