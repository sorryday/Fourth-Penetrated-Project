package com.gumi.enjoytrip.domain.hotplace.dto;

public class HotPlaceListDto {
    private long id;
    private String title;
    private int placeType;
    private String createdAt;
    private long creatorId;
    private String creatorNickname;

    public HotPlaceListDto() {
    }

    public HotPlaceListDto(long id, String title, int placeType, String createdAt, long creatorId, String creatorNickname) {
        this.id = id;
        this.title = title;
        this.placeType = placeType;
        this.createdAt = createdAt;
        this.creatorId = creatorId;
        this.creatorNickname = creatorNickname;
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

    public int getPlaceType() {
        return placeType;
    }

    public void setPlaceType(int placeType) {
        this.placeType = placeType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorNickname() {
        return creatorNickname;
    }

    public void setCreatorNickname(String creatorNickname) {
        this.creatorNickname = creatorNickname;
    }
}
