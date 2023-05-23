package com.gumi.enjoytrip.domain.post.service;

import com.gumi.enjoytrip.domain.post.dto.PostCreateDto;
import com.gumi.enjoytrip.domain.post.dto.PostDto;
import com.gumi.enjoytrip.domain.post.dto.PostListDto;
import com.gumi.enjoytrip.domain.post.dto.PostUpdateDto;

import java.util.List;

public interface PostService {
    List<PostListDto> getPostList();
    PostDto getPost(long id);
    void createPost(PostCreateDto postCreateDto);
    void updatePost(long id, PostUpdateDto postUpdateDto, long creatorId);
    void deletePost(long id, long creatorId);
    void setNotice(long id, boolean isNotice, long userId);
    List<PostListDto> getPostListByKeyword(String keyword);
    void likePost(long id, long userId);
    void unlikePost(long id, long userId);
}
