package com.github.Shurtugall.SauceDemoWebTest.test.utils;

public enum USERNAMES {
	STANDARD("standard_user"),
	LOCKED_OUT("locked_out_user"),
	PROBLEM("problem_user"),
	PERFORMANCE_GLITCH("performance_glitch_user"),
	ERROR("error_user"),
	VISUAL("visual_user");
	
	public String userValue;
	
	USERNAMES(String user){
		  userValue = user;
	}
	
	public String getUsername() {
		return userValue;
	}
}
