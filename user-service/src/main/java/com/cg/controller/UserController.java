package com.cg.controller;

import java.util.Arrays;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.models.AuthenticationRequest;
import com.cg.models.AuthenticationResponse;
import com.cg.models.OrderDetails;
//import com.cg.models.Payment;
import com.cg.models.UserDetail;
import com.cg.models.UserLogin;
import com.cg.models.UserRating;
import com.cg.models.Washpack;
import com.cg.service.LoginService;
import com.cg.service.MyUserDetailsService;
import com.cg.service.UserService;
import com.cg.service.UserServiceImplementation;
import com.cg.util.JwtUtil;

import io.swagger.annotations.ApiOperation;
/* Name:Abhijeet kant
 * EmpId: 46195747
 * 
 * 
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private LoginService userLogin;
	@Autowired
	private UserServiceImplementation service;
	
	@Autowired
	private UserService user;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService;

	 

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	

	@PostMapping("/adduser")
	@ApiOperation(value = "Adds new Customer's details")
	public UserDetail saveUser(@RequestBody UserDetail signup) {
		logger.info("Adding User");
		signup.setId(service.getSequenceNumber(UserDetail.SEQUENCE_NAME));
		return service.addUser(signup);
	}

	@GetMapping("/allusers")
	@ApiOperation(value = "Shows all Customer's details")
	public List<UserDetail> findAllUsers() {
		logger.info("Getting all customers details");
		return service.getuser();
	}

	@PutMapping("/updateUser")
	@ApiOperation(value = "Updates Customer's details")
	public UserDetail updateUser(@RequestBody UserDetail signup) {
		 logger.info("Updating users details");
		UserDetail result = service.Updateuser(signup);
		 logger.info("Successfully updated user details");
		return result;
	}

	@DeleteMapping("/deleteUser/{id}")
	@ApiOperation(value = "Deletes customer")
	public void deleteuser(@RequestParam int id) {
		logger.info("Deleted user by id");
		service.deleteUser(id);
	}
	/*-------------------UserLogin----------------------------- */
	
	@PostMapping("/login")
	@ApiOperation(value = "To Add Login Details")
	public String userLogin(@RequestBody UserLogin login) {
		logger.info("User login");
		return userLogin.userLogin(login);
	}
	
	/*-------------------Resttemplates----------------------------- */

	@GetMapping("/washpack")
	@ApiOperation(value = "Gets all packs")
	public List<Washpack> getwashpacks() {
		String baseurl = "http://localhost:8084/admin/washpack";
		Washpack[] wp = restTemplate.getForObject(baseurl, Washpack[].class);
		return Arrays.asList(wp);
	}

	@PostMapping("/addorder")
	@ApiOperation(value = "User can add new order")
	public String addorder(@RequestBody OrderDetails order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> entity = new HttpEntity<OrderDetails>(order, headers);

		return restTemplate.exchange("http://localhost:8081/order/addorder", HttpMethod.POST, entity, String.class)
				.getBody();
	}



	@DeleteMapping(value = "/delete/{orderId}")
	public String deleteById(@PathVariable("orderId") int orderId) {
		restTemplate.delete("http://localhost:8081/order/delete/{orderId}", orderId, String.class);
		return "Order with Id = " + orderId + " Deleted Successfully";
	}
	
	@PostMapping("/addrating")
	@ApiOperation(value = "User can give ratings to washers")
	public String addrating(@RequestBody UserRating rating) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserRating> entity = new HttpEntity<UserRating>(rating, headers);

		return restTemplate.exchange("http://localhost:8084/admin/addrating", HttpMethod.POST, entity, String.class)
				.getBody();
	}


}
