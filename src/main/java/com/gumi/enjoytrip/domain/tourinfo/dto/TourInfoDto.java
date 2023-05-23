
package com.gumi.enjoytrip.domain.tourinfo.dto;

public class TourInfoDto {
	private int contentId;
	private int contentTypeId;
	private String title;
	private String address;
	private String image;
	private String content;
	private int sidoCode;
	private int gugunCode;
	private double latitude;
	private double longitude;

	public TourInfoDto() {
	}

	public TourInfoDto(int contentId, int contentTypeId, String title, String address, String image,
					   String content, int sidoCode, int gugunCode, double latitude, double longitude) {
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.title = title;
		this.address = address;
		this.image = image;
		this.content = content;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
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

}
