package com.gumi.enjoytrip.domain.user.controller;

import com.gumi.enjoytrip.domain.user.dto.UserCreateDto;
import com.gumi.enjoytrip.domain.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String root = request.getContextPath();
		if(UserServiceImpl.getInstance().getUser(userId) != null) {
			response.sendRedirect(root + "/error/duplicate-user-id.html");
		}
		else {
			UserCreateDto dto = new UserCreateDto(userId, password, email, nickname);
			UserServiceImpl.getInstance().createUser(dto);
			response.sendRedirect(root + "/trip/user/login.jsp");
		}
    }
}
