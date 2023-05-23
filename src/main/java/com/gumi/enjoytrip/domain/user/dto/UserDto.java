package com.gumi.enjoytrip.domain.user.dto;

public class UserDto {
	private Long id;
	private String userId;
	private String email;
	private String nickname;
	private String role;
	
	public UserDto() {
	}

	public UserDto(Long id, String userId, String email, String nickname, String role) {
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.nickname = nickname;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
