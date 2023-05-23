package com.gumi.enjoytrip.domain.post.dao;

import com.gumi.enjoytrip.domain.post.dto.PostCreateDto;
import com.gumi.enjoytrip.domain.post.dto.PostDto;
import com.gumi.enjoytrip.domain.post.dto.PostListDto;
import com.gumi.enjoytrip.domain.post.dto.PostUpdateDto;

import java.util.List;

public interface PostDao {
    List<PostListDto> getPostList();
    PostDto getPost(long id);
    void createPost(PostCreateDto postDto);
    void updatePost(long id, PostUpdateDto postDto);
    void deletePost(long id);
    void setNotice(long id, boolean isNotice);
    List<PostListDto> getPostListByKeyword(String keyword);
    void likePost(long id, long userId);
    void unlikePost(long id, long userId);
}
