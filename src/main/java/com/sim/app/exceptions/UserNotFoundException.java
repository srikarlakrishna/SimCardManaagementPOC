package com.sim.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9070227800205123011L;

	public UserNotFoundException(String exception) {
		super(exception);
	}

}