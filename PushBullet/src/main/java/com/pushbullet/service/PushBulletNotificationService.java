package com.pushbullet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pushbullet.models.PushBulletNotficiationBody;
import com.pushbullet.models.PushBulletRequest;
import com.pushbullet.models.UserModel;

@Service
public class PushBulletNotificationService {
	private final String URL = "https://api.pushbullet.com/v2/pushes";
	
	@Autowired
	private RestTemplate restTemplate;
	
		 
	public void pushNotfication(UserModel user, PushBulletNotficiationBody pushBulletNotficiationBody) {
		try {

			PushBulletRequest pushBulletRequest = new PushBulletRequest(pushBulletNotficiationBody.getTitle(), pushBulletNotficiationBody.getMessage());
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("Access-Token", user.getAccessToken());
			HttpEntity<PushBulletRequest> request = new HttpEntity<>(pushBulletRequest, headers);
		
			this.restTemplate.postForObject(URL, request, PushBulletRequest.class);
		} catch(Exception  error) {
			System.out.println(error);
		}
		
	}
}
