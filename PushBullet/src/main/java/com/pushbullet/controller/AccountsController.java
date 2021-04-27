package com.pushbullet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.pushbullet.models.RegisterUserModel;
import com.pushbullet.service.AccountsService;

@RestController
@RequestMapping()
public class AccountsController {
	
	@Autowired
	AccountsService accountsService;
	
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createStudent (@RequestBody RegisterUserModel registerUserModel) {
		accountsService.createUser(registerUserModel);
	}
}
