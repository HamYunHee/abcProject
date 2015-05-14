package com.shshop.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shshop.command.Command;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 2335728773164645554L;

	public Command getCommand(HttpServletRequest request)
	{
		RequestHelper helper = new RequestHelper(request);
		Command command = helper.getCommand();
		return command;
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		 
		Command command =  getCommand(request);
		
		CommandResult result = command.execute(request, response);
		
		if (result.getViewURI() != null) {
			dispatch(request, response, result.getViewURI());
		} else {
			sendContent(request, response, result);
		}
	}
	
	public void sendContent(HttpServletRequest request, HttpServletResponse response, CommandResult commandResult) {
		response.setContentType(commandResult.getContentType());
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(commandResult.getContent());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String viewURI) 
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(viewURI);
		rd.forward(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		processRequest(request, response);
	}
}
