package com.gumi.enjoytrip.domain.post.dto;

public class PostDto {
    private long id;
    private String title;
    private String content;
    private int hits;
    private boolean isNotice;
    private int likeCount;
    private long creatorId;
    private String creatorNickname;
    private String createdAt;

    public PostDto(long id, String title, String content, int hits, boolean isNotice, int likeCount, long creatorId, String creatorNickname, String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hits = hits;
        this.isNotice = isNotice;
        this.likeCount = likeCount;
        this.creatorId = creatorId;
        this.creatorNickname = creatorNickname;
        this.createdAt = createdAt;
    }

    public PostDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public boolean getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(boolean isNotice) {
        this.isNotice = isNotice;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCreatorNickname() {
        return creatorNickname;
    }

    public void setCreatorNickname(String creatorNickname) {
        this.creatorNickname = creatorNickname;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
