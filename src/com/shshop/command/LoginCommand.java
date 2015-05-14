package com.shshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shshop.control.CommandResult;
import com.shshop.domain.User;
import com.shshop.service.AuthenticatorService;
import com.shshop.util.RegExpressionUtil;

public class LoginCommand implements Command {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean hasValidEmail = false;
		boolean hasPassword = false;

		if (email != null && email.trim().length() > 0 && RegExpressionUtil.isValidEmail(email)) {
			hasValidEmail = true;
		}

		if (password != null && password.trim().length() > 0) {
			hasPassword = true;
		}

		CommandResult commandResult = null;

		if (!hasValidEmail) {
			commandResult = new CommandResult("text/html", "<h3>U need to put vaild email address.</h3>");
		} else if (!hasPassword) {
			commandResult = new CommandResult("text/html", "<h3>U need to put vaild password.</h3>");
		} else {

			AuthenticatorService authenticator = new AuthenticatorService();

			User user = authenticator.getExistsUser(email, password);
			
			if (user != null) {

				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
 
				session = request.getSession(false);
				
				synchronized (session) {

					session.setAttribute("user", user);
				}

				commandResult = new CommandResult("/WEB-INF/view/login.jsp");
			} else {
				commandResult = new CommandResult("text/html", "<h3>There is no adapted person.</h3>");
			}
		}

		return commandResult;
	}
}