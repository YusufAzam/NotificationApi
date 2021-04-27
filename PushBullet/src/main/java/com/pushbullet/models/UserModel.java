package com.pushbullet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;


@AllArgsConstructor
@Getter
@Setter
public class UserModel {
	@JsonProperty("username")
	private String username;
	
	private String accessToken;
	private String creationTime;
	private Integer numOfNotificationsPushed;
	
	public void incrementNumOfNotificationsPushed() {
		this.numOfNotificationsPushed = this.numOfNotificationsPushed + 1;
	}
	
}