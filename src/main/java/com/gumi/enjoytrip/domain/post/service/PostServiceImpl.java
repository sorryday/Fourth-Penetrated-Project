package com.gumi.enjoytrip.domain.post.service;

import com.gumi.enjoytrip.domain.post.dao.PostDaoImpl;
import com.gumi.enjoytrip.domain.user.dao.UserDaoImpl;
import com.gumi.enjoytrip.domain.post.dto.PostCreateDto;
import com.gumi.enjoytrip.domain.post.dto.PostDto;
import com.gumi.enjoytrip.domain.post.dto.PostListDto;
import com.gumi.enjoytrip.domain.post.dto.PostUpdateDto;

import java.util.List;

public class PostServiceImpl implements PostService{
    private static PostService instance = null;

    private PostServiceImpl() {
    }

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostServiceImpl();
        }
        return instance;
    }

    public List<PostListDto> getPostList() {
        return PostDaoImpl.getInstance().getPostList();
    }

    public PostDto getPost(long id) {
        return PostDaoImpl.getInstance().getPost(id);
    }

    public void createPost(PostCreateDto postCreateDto) {
        PostDaoImpl.getInstance().createPost(postCreateDto);
    }

    public void updatePost(long id, PostUpdateDto postUpdateDto, long creatorId) {
        if(PostDaoImpl.getInstance().getPost(id).getCreatorId() != creatorId) {
            throw new RuntimeException("작성자만 수정할 수 있습니다.");
        }
        PostDaoImpl.getInstance().updatePost(id, postUpdateDto);
    }

    public void deletePost(long id, long creatorId) {
        if(PostDaoImpl.getInstance().getPost(id).getCreatorId() != creatorId) {
            throw new RuntimeException("작성자만 삭제할 수 있습니다.");
        }
        PostDaoImpl.getInstance().deletePost(id);
    }

    public void setNotice(long id, boolean isNotice, long userId) {
        if(!UserDaoImpl.getInstance().getUser(userId).getRole().equals("ADMIN")) {
            throw new RuntimeException("관리자만 공지사항을 설정 및 해제할 수 있습니다.");
        }
        PostDaoImpl.getInstance().setNotice(id, isNotice);
    }

    public List<PostListDto> getPostListByKeyword(String keyword) {
        return PostDaoImpl.getInstance().getPostListByKeyword(keyword);
    }

    @Override
    public void likePost(long id, long userId) {
        PostDaoImpl.getInstance().likePost(id, userId);
    }

    @Override
    public void unlikePost(long id, long userId) {
        PostDaoImpl.getInstance().unlikePost(id, userId);
    }
}
