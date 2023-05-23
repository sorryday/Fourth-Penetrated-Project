package com.gumi.enjoytrip.domain.user.controller;

import com.gumi.enjoytrip.domain.user.dto.UserDto;
import com.gumi.enjoytrip.domain.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change-password")
public class PasswordChangeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserDto user = (UserDto) request.getSession().getAttribute("user");
        long id = user.getId();
        String userId = user.getUserId();
        String password = request.getParameter("password");
        String newPassword = request.getParameter("new-password");
        String root = request.getContextPath();
        UserDto dto = UserServiceImpl.getInstance().getLoginUser(userId, password);
        if (dto != null) {
            UserServiceImpl.getInstance().changePassword(id, newPassword);
            response.sendRedirect(root + "/trip/user/my-page.jsp");
        } else {
            response.sendRedirect(root + "/error/wrong-current-password.html");
        }
    }
}
