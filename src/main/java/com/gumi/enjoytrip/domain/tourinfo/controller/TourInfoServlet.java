package com.gumi.enjoytrip.domain.tourinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gumi.enjoytrip.domain.tourinfo.dto.TourInfoDto;
import com.gumi.enjoytrip.domain.tourinfo.service.TourInfoServiceImpl;

/**
 * Servlet implementation class MapServlet
 */
@WebServlet("/tour-info")
public class TourInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sidoCode = Integer.parseInt(request.getParameter("sido-code"));
		int gugunCode = Integer.parseInt(request.getParameter("gugun-code"));
		int typeCode = Integer.parseInt(request.getParameter("type-code"));
		List<TourInfoDto> list = TourInfoServiceImpl.getInstance().getTourInfoList(sidoCode, gugunCode, typeCode);;
		String flag;
		if (list.size() != 0) {
			System.out.println("list size=0");
			flag = "found";
			/* request객체 */
			RequestDispatcher rd = request.getRequestDispatcher("trip/tour/tour-info.jsp");
			request.setAttribute("maplist", list); // 리케스트명: emplist
			request.setAttribute("condition", flag);
			rd.forward(request, response); // empList.jsp에 권한을 위임
		} else {
			flag = "notfound";
			System.out.println(flag);
			RequestDispatcher rd = request.getRequestDispatcher("trip/tour/tour-info.jsp");
			request.setAttribute("maplist", list); // 리케스트명: emplist
			request.setAttribute("condition", flag);
			rd.forward(request, response); // empList.jsp에 권한을 위임
		}
	}
}
