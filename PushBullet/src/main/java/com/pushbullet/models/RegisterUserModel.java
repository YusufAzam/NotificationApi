package com.pushbullet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterUserModel {
	@JsonProperty("username")
	private String userName;
	private String accessToken;
}
