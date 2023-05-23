package com.gumi.enjoytrip.domain.user.controller;

import com.gumi.enjoytrip.domain.user.dto.UserDto;
import com.gumi.enjoytrip.domain.user.dto.UserUpdateDto;
import com.gumi.enjoytrip.domain.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-profile")
public class ProfileEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserDto user = (UserDto) req.getSession().getAttribute("user");
        long id = user.getId();
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");
        UserServiceImpl.getInstance().updateUser(id, new UserUpdateDto(id, email, nickname));
        req.getSession().removeAttribute("user");
        UserDto dto = UserServiceImpl.getInstance().getUser(id);
        req.getSession().setAttribute("user", dto);
        String root = req.getContextPath();
        resp.sendRedirect(root + "/trip/user/my-page.jsp");
    }
}
