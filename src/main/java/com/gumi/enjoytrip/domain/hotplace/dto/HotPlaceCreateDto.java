package com.gumi.enjoytrip.domain.hotplace.dto;

import java.util.Date;

public class HotPlaceCreateDto {
    private String title;
    private String content;
    private int placeType;
    private double latitude;
    private double longitude;
    private long creatorId;
    private Date date;

    public HotPlaceCreateDto() {
    }

    public HotPlaceCreateDto(String title, String content, int placeType, double latitude, double longitude, long creatorId, Date date) {
        this.title = title;
        this.content = content;
        this.placeType = placeType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.creatorId = creatorId;
        this.date = date;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
