package com.gumi.enjoytrip.domain.user.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		process(request,response);
		System.out.println(request.getRequestURL());
		int test = 3;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("포스트방식으로 넘어옴");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String action = request.getParameter("action");
//		switch (action) {
//			case "login":	//로그인
////				System.out.println("its login");
//				doLogin(request, response);
//				break;
//			case "logout":	//로그인
//				doLogout(request, response);
//				break;
//			case "register": //회원가입
////				System.out.println("it's signup");
//				doRegister(request,response);
//				break;
//			case "mypage": //mypage 수정
//				doEdit(request,response);
//				break;
//			case "quit": //회원탈퇴
//				doQuit(request,response);
//				break;
////			case "findpw": //
////				break;
//		}
//	}




//	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String id = request.getParameter("user_id");
//		String pw = request.getParameter("password");
//
//		String root = request.getContextPath();
//		UserDto dto = UserServiceImpl.getInstance().getLoginUser(id, pw);
//
//		if (dto != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", dto);
//			response.sendRedirect(root + "/my-page.jsp");
//		} else {
//			response.sendRedirect(root + "/login.jsp?error=true");
//		}
//	}
//
//	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		HttpSession session = request.getSession();
//		UserDto dto = (UserDto) session.getAttribute("userInfo");
//
//		String root = request.getContextPath();
//
//		if(dto != null) {
//			session.removeAttribute("userInfo");
//			response.sendRedirect(root + "/index.jsp");
//		}
//	}
//
//	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String root = request.getContextPath();
//
//		UserDTO dto = new UserDTO();
//		String id = request.getParameter("user_id");
//		String pw = request.getParameter("passwordNew");
//		String pw2 = request.getParameter("passwordNew2");
//		String nickname = request.getParameter("nickname");
//		String email = request.getParameter("email");
//
//		if(id=="" || pw=="" || nickname=="" || email=="") {
//			response.sendRedirect(root+"/register.jsp?error=blank");
//			return;
//		}
//		if(!pw.equals(pw2)){
//			response.sendRedirect(root+"/register.jsp?error=true");
//			return;
//		}
//		dto.setUser_id(id);
//		dto.setPassword(pw);
//		dto.setEmail(email);
//		dto.setNickname(nickname);
//
//		int n = UserServiceImpl.getInstance().createUser(dto);
//
//		if (n > 0) {
//			response.sendRedirect(root + "/login.jsp?signup=true");
//		} else {
//			response.sendRedirect(root + "/register.jsp?error=true");
//		}
//	}
//
//
//	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String root = request.getContextPath();
//
//		UserDTO dto = new UserDTO();
//		String pw = request.getParameter("passwordNew");
//		String pw2 = request.getParameter("passwordNew2");
//		if(!pw.equals(pw2)) {
//			response.sendRedirect(root+"/my-page.jsp?error=true");
//			return;
//		}
//		dto.setPassword(pw);
//		dto.setUser_id(request.getParameter("user_id"));
//		dto.setEmail(request.getParameter("email"));
//		dto.setNickname(request.getParameter("nickname"));
//
//		int n = UserServiceImpl.getInstance().updateUser(dto);
//
//		if (n > 0) {
//			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", dto);
//			response.sendRedirect(root + "/my-page.jsp?error=false");
//		} else {
//			response.sendRedirect(root + "/my-page.jsp?error=true");
//		}
//	}
//
//
//	private void doQuit(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		int n = UserServiceImpl.getInstance().deleteUser(request.getParameter("user_id"));
//
//		String root = request.getContextPath();
//		if (n > 0) {
//			HttpSession session = request.getSession();
//			session.removeAttribute("userInfo");
//			response.sendRedirect(root + "/login.jsp?error=quit");
//		} else {
//			response.sendRedirect(root + "/my-page.jsp");
//		}
//	}
}
