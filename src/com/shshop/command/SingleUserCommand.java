package com.shshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shshop.control.CommandResult;
import com.shshop.service.AuthenticatorService;

public class SingleUserCommand implements Command{

	@Override
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		CommandResult comm = null;
		
		AuthenticatorService attService = new AuthenticatorService();
		
		request.setAttribute("user", attService.getViewSingleUser(3));
		
		comm = new CommandResult("/WEB-INF/view/join.jsp");
		
		return comm;
	}
	
}
