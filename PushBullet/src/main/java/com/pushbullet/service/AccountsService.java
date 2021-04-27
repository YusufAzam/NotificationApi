package com.pushbullet.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.pushbullet.exceptions.DuplicateUserException;
import com.pushbullet.models.RegisterUserModel;
import com.pushbullet.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {
	
private  List<UserModel> listOfUsers = new ArrayList<UserModel>();
	
	public Boolean createUser(RegisterUserModel registerUserModel) {
			
		UserModel user = new UserModel(
				registerUserModel.getUserName(),
				registerUserModel.getAccessToken(),
				Instant.now().toString().substring(0,19),
				0);
		
		if(!this.listOfUsers.stream().anyMatch(userItem -> userItem.getUsername().equals(registerUserModel.getUserName()))) {
			this.listOfUsers.add(user);
			return true;
		}
		throw new DuplicateUserException("User " + registerUserModel.getUserName() + " already exists");
	}
	
	public List<UserModel> getAllUsers() {
		return listOfUsers;
	}
	
	public UserModel getUser(String userName) {
		for(UserModel userModel: this.listOfUsers) {
			 if(userModel.getUsername().equals(userName)) {
				 return userModel;
			 }
		 }
		return null;
	}
	
	public void increment(String userName) {
		this.listOfUsers.forEach(user -> {
			if(user.getUsername().equals(userName)) {
				user.incrementNumOfNotificationsPushed();
			}
		});
	}
}
