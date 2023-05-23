package com.gumi.enjoytrip.domain.user.controller;

import com.gumi.enjoytrip.domain.user.dto.UserDto;
import com.gumi.enjoytrip.domain.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("user-id");
        String pw = request.getParameter("password");
        String root = request.getContextPath();
        UserDto dto = UserServiceImpl.getInstance().getLoginUser(userId, pw);
        if (dto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", dto);
            response.sendRedirect(root + "/trip/user/my-page.jsp");
        } else {
            response.sendRedirect(root + "/error/wrong-id-or-password.html");
        }
    }
}
