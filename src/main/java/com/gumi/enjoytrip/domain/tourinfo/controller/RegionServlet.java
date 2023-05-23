package com.gumi.enjoytrip.domain.tourinfo.controller;

import com.google.gson.Gson;
import com.gumi.enjoytrip.domain.tourinfo.service.RegionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regions")
public class RegionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("mode") != null) {
            if (req.getParameter("mode").equals("sido")) {
                String sidoJsonString = new Gson().toJson(RegionServiceImpl.getInstance().getSidoList());
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                System.out.println(sidoJsonString);
                resp.getWriter().write(sidoJsonString);
            } else if (req.getParameter("mode").equals("gugun") && req.getParameter("sido_code") != null) {
                int sidoCode = Integer.parseInt(req.getParameter("sido_code"));
                String gugunJsonString = new Gson().toJson(RegionServiceImpl.getInstance().getGugunList(sidoCode));
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(gugunJsonString);
            }
        }
    }
}
