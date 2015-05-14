package com.shshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shshop.control.CommandResult;
import com.shshop.domain.User;
import com.shshop.service.AuthenticatorService;

public class JoinCommand implements Command{

	@Override
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String ktalkId = request.getParameter("ktalk");
		
		User user = new User(email, password, name, phone, ktalkId);
		
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getKtalkId());
		
		AuthenticatorService attService = new AuthenticatorService();
		attService.signUser(user);
		
		CommandResult commandResult = new CommandResult("/header.html");
		
		return commandResult;
	}

}
