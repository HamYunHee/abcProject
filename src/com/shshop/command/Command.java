package com.shshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shshop.control.CommandResult;

public interface Command {
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response);
}
