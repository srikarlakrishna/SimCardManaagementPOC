package com.sim.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sim.app.entities.Operator;
import com.sim.app.entities.Users;
import com.sim.app.exceptions.UserNotFoundException;
import com.sim.app.service.SimCardService;

@RestController
@RequestMapping(value = "/api/users")
public class SimCardController implements ErrorController {

	@Autowired
	private SimCardService simCardService;

	@PostMapping(value = "/newUser")
	public Users createUser(@RequestBody Users user) {
		return simCardService.createUser(user);
	}

	@GetMapping(value = "/{userId}")
	public Users getUserById(@PathVariable("userId") Long userId) {
		Users findOne = simCardService.getUserById(userId);
		if (findOne == null) {
			throw new UserNotFoundException("User Not Found");
		}
		return findOne;
	}

	@GetMapping(value = "/byNetwork/{networkName}")
	public List<Users> getUsersByNetwork(@PathVariable("networkName") String networkName) {

		Operator operator = Operator.valueOf(networkName);
		List<Users> listOfUSers = simCardService.getListOfUSersByNetwoek(operator.ordinal());

		return listOfUSers;
	}

	@GetMapping(value = "/allUsers")
	public Iterable<Users> getAllUsers() {
		return simCardService.getAllUsers();
	}

	@DeleteMapping(value = "/inActive/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		simCardService.deleteUser(userId);
	}

	public static String PATH = "/error";

	@GetMapping(value = "/error")
	public String defaultError() {
		return "default error message";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
