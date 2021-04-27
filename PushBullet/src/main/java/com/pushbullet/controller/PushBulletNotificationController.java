package com.pushbullet.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pushbullet.models.PushBulletNotficiationBody;
import com.pushbullet.models.UserModel;
import com.pushbullet.service.AccountsService;
import com.pushbullet.service.PushBulletNotificationService;


@RestController
@Validated
@RequestMapping("/push")
public class PushBulletNotificationController {
	
	@Autowired
	AccountsService accountsService;
	
	@Autowired
	PushBulletNotificationService pushBulletNotificationService;
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void putUserRequest(@RequestBody PushBulletNotficiationBody pushBulletNotficiationBody) {
		UserModel user = accountsService.getUser(pushBulletNotficiationBody.getUsername());
		pushBulletNotificationService.pushNotfication(user, pushBulletNotficiationBody);;
		accountsService.increment(pushBulletNotficiationBody.getUsername());
		return;
	}

}
