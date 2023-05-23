package com.gumi.enjoytrip.domain.user.dto;

public class UserUpdateDto {
    private long id;
    private String email;
    private String nickname;

    public UserUpdateDto() {
    }

    public UserUpdateDto(long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
