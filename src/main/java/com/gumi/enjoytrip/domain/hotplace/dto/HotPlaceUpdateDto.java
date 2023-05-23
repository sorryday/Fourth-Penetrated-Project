package com.gumi.enjoytrip.domain.hotplace.dto;

public class HotPlaceUpdateDto {
    long id;
    private String title;
    private String content;
    private int placeType;
    private long creatorId;

    public HotPlaceUpdateDto() {
    }

    public HotPlaceUpdateDto(long id, String title, String content, int placeType, long creatorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.placeType = placeType;
        this.creatorId = creatorId;
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

    public int getPlaceType() {
        return placeType;
    }

    public void setPlaceType(int placeType) {
        this.placeType = placeType;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }
}
