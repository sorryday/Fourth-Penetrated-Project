package com.gumi.enjoytrip.domain.hotplace.controller;

import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceCreateDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceDto;
import com.gumi.enjoytrip.domain.hotplace.dto.HotPlaceUpdateDto;
import com.gumi.enjoytrip.domain.hotplace.service.HotPlaceServiceImpl;
import com.gumi.enjoytrip.domain.user.dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/hotplaces")
public class HotPlaceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            long id = Integer.parseInt(request.getParameter("id"));
            HotPlaceDto hotPlaceDto = HotPlaceServiceImpl.getInstance().getHotPlace(id);
            request.setAttribute("hotplace", hotPlaceDto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("trip/hotplace/hotplace.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("condition") != null && request.getParameter("keyword") != null) {
            int pageNumber = request.getParameter("page-number") == null ? 1 : Integer.parseInt(request.getParameter("page-number"));
            String condition = request.getParameter("condition");
            String keyword = request.getParameter("keyword");
            request.setAttribute("hotplaces", HotPlaceServiceImpl.getInstance().getHotPlaceListByKeyword(condition, keyword, pageNumber));
            RequestDispatcher dispatcher = request.getRequestDispatcher("trip/hotplace/hotplace-list.jsp");
            dispatcher.forward(request, response);
        } else {
            int pageNumber = request.getParameter("page-number") == null ? 1 : Integer.parseInt(request.getParameter("page-number"));
            request.setAttribute("hotplaces", HotPlaceServiceImpl.getInstance().getHotplaceList(pageNumber));
            RequestDispatcher dispatcher = request.getRequestDispatcher("trip/hotplace/hotplace-list.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        if (request.getParameter("mode") != null && request.getParameter("mode").equals("create")) {
            try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int placeType = Integer.parseInt(request.getParameter("place-type"));
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(request.getParameter("date"));
            UserDto user = (UserDto) request.getSession().getAttribute("user");
            HotPlaceServiceImpl.getInstance().createHotPlace(new HotPlaceCreateDto(title, content, placeType, latitude, longitude, user.getId(), date));
            String root = request.getContextPath();
            response.sendRedirect(root + "/hotplaces");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (request.getParameter("mode") != null && request.getParameter("mode").equals("update")) {
            long id = Long.parseLong(request.getParameter("id"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int placeType = Integer.parseInt(request.getParameter("place-type"));
            UserDto user = (UserDto) request.getSession().getAttribute("user");
            HotPlaceServiceImpl.getInstance().updateHotPlace(id, new HotPlaceUpdateDto(id, title, content, placeType, user.getId()));
            String root = request.getContextPath();
            response.sendRedirect(root + "/hotplaces");
        }
        // 잘못된 접근
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        HotPlaceServiceImpl.getInstance().deleteHotPlace(id);
        // 페이지 이동
    }
}
