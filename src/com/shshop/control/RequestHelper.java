package com.shshop.control;

import javax.servlet.http.HttpServletRequest;

import com.shshop.command.Command;

public class RequestHelper {
	private HttpServletRequest request;
	
	public RequestHelper (HttpServletRequest request) {
		this.request = request;
	}
	
	public Command getCommand(){
		return CommandFactory.createCommand(request.getPathInfo());
	}
}
