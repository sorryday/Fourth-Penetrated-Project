package com.gumi.enjoytrip.domain.hotplace.dto;

public class HotPlaceDto {
	private long id;
	private String title;
	private String content;
	private int placeType;
	private String createdAt;
	private long creatorId;
	private String creatorNickname;
	private double latitude;
	private double longitude;
	private String date;

	public HotPlaceDto() {
	}

	public HotPlaceDto(long id, String title, String content, int placeType, String createdAt, long creatorId, String creatorNickname, double latitude,
					   double longitude, String date) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.placeType = placeType;
		this.createdAt = createdAt;
		this.creatorId = creatorId;
		this.creatorNickname = creatorNickname;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
