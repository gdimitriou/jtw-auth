package com.auth.jwt.spring.controller;

import com.auth.jwt.spring.jwt.JwtUtil;
import com.auth.jwt.spring.model.AuthenticationRequest;
import com.auth.jwt.spring.model.AuthenticationResponse;
import com.auth.jwt.spring.model.RegisterUser;
import com.auth.jwt.spring.service.MyUserDetailsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;


	@CrossOrigin
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();

		try {

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		} catch (BadCredentialsException e) {

			throw new Exception("Incorrect username or password", e);


		}

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

		final String jwt = jwtUtil.generateToken(userDetails);

		AuthenticationResponse authenticationResponse = new AuthenticationResponse();

		authenticationResponse.setJwt(jwt);

		return ResponseEntity.ok(authenticationResponse);
	}

	// Only authenticated users can access this API
	@CrossOrigin
	@GetMapping(value = "/hello")
	public ResponseEntity<String> hello() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "JWT TOKEN");

		return ResponseEntity.ok()
				.headers(headers)
				.body("SUCCESS");
	}

	@CrossOrigin
	@ApiOperation(value = "Register User.")
	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<?> register(@RequestBody RegisterUser registerUser) {

		String firstName  = registerUser.getFirstName();
		String lastName = registerUser.getLastName();
		String userName  = registerUser.getUserName();
		String password = registerUser.getPassword();
		String email = registerUser.getEmail();
		String occupation = registerUser.getOccupation();
		String city = registerUser.getCity();
		String bio = registerUser.getBio();

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(email);
		System.out.println(occupation);
		System.out.println(city);
		System.out.println(bio);

		if (firstName != null) {
			return ResponseEntity.ok("Success");
		}
		else
			return ResponseEntity.ok("Something is null");
	}
}
