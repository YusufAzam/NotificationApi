package com.pushbullet.models;

import lombok.Getter;
import lombok.Setter;

interface Type {
	final public static String NOTE = "note";
}

@Getter
@Setter
public class PushBulletRequest {
	String type = Type.NOTE;
	String title;
	String body;
	
	public PushBulletRequest(String title, String body){
		this.title = title;
		this.body = body;
	}
	
}
