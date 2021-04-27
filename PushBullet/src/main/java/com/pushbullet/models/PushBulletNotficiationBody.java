package com.pushbullet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PushBulletNotficiationBody {
	  String username;
	  String title = "Deafult title";
	  String message = "Message";
	  
}

