package com.shshop.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shshop.service.CategoryControlService;

@WebServlet("/test/*")
public class CategoryLoadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		CategoryControlService categoryControlService = new CategoryControlService();
		response.getWriter().write(categoryControlService.buildHtml());
	}
}
