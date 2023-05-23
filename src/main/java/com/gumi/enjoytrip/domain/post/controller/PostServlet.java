package com.gumi.enjoytrip.domain.post.controller;

import com.gumi.enjoytrip.domain.post.dto.PostCreateDto;
import com.gumi.enjoytrip.domain.post.dto.PostDto;
import com.gumi.enjoytrip.domain.post.dto.PostListDto;
import com.gumi.enjoytrip.domain.post.dto.PostUpdateDto;
import com.gumi.enjoytrip.domain.post.service.PostServiceImpl;
import com.gumi.enjoytrip.domain.user.dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/posts")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("keyword") != null) {
            System.out.println("Y");
            String keyword = req.getParameter("keyword");
            List<PostListDto> posts = PostServiceImpl.getInstance().getPostListByKeyword(keyword);
            req.setAttribute("posts", posts);
            RequestDispatcher dispatcher = req.getRequestDispatcher("trip/post/post-list.jsp");
            dispatcher.forward(req, resp);
        } else if (req.getParameter("id") == null) {
            List<PostListDto> posts = PostServiceImpl.getInstance().getPostList();
            req.setAttribute("posts", posts);
            RequestDispatcher dispatcher = req.getRequestDispatcher("trip/post/post-list.jsp");
            dispatcher.forward(req, resp);
        } else if (req.getParameter("mode") != null && req.getParameter("mode").equals("edit")) {
            long id = Long.parseLong(req.getParameter("id"));
            PostDto post = PostServiceImpl.getInstance().getPost(id);
            req.setAttribute("post", post);
            RequestDispatcher dispatcher = req.getRequestDispatcher("trip/post/post-update.jsp");
            dispatcher.forward(req, resp);
        } else {
            long id = Long.parseLong(req.getParameter("id"));
            PostDto post = PostServiceImpl.getInstance().getPost(id);
            req.setAttribute("post", post);
            RequestDispatcher dispatcher = req.getRequestDispatcher("trip/post/post.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("mode") != null && req.getParameter("mode").equals("edit")) {
            long id = Long.parseLong(req.getParameter("id"));
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            UserDto user = (UserDto) req.getSession().getAttribute("user");
            PostServiceImpl.getInstance().updatePost(id, new PostUpdateDto(id, title, content), user.getId());
            String root = req.getContextPath();
            resp.sendRedirect(root + "/posts?id=" + id);
        } else if (req.getParameter("notice") != null) {
            long id = Long.parseLong(req.getParameter("id"));
            boolean isNotice = Boolean.parseBoolean(req.getParameter("notice"));
            UserDto user = (UserDto) req.getSession().getAttribute("user");
            PostServiceImpl.getInstance().setNotice(id, isNotice, user.getId());
            resp.setStatus(200);
        } else if (req.getParameter("like") != null) {
            long id = Long.parseLong(req.getParameter("id"));
            boolean isLike = Boolean.parseBoolean(req.getParameter("like"));
            UserDto user = (UserDto) req.getSession().getAttribute("user");
            if (isLike)
                PostServiceImpl.getInstance().likePost(id, user.getId());
            else
                PostServiceImpl.getInstance().unlikePost(id, user.getId());
            resp.setStatus(200);
        } else {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            UserDto user = (UserDto) req.getSession().getAttribute("user");
            PostServiceImpl.getInstance().createPost(new PostCreateDto(title, content, user.getId()));
            String root = req.getContextPath();
            resp.sendRedirect(root + "/posts");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        UserDto user = (UserDto) req.getSession().getAttribute("user");
        PostServiceImpl.getInstance().deletePost(id, user.getId());
        resp.setStatus(200);
    }
}
