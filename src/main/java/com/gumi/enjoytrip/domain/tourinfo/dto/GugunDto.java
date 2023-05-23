package com.gumi.enjoytrip.domain.tourinfo.dto;

public class GugunDto {
    private int gugunCode;
    private String gugunName;
    private int sidoCode;

    public GugunDto() {
    }

    public GugunDto(int gugunCode, String gugunName, int sidoCode) {
        this.gugunCode = gugunCode;
        this.gugunName = gugunName;
        this.sidoCode = sidoCode;
    }

    public int getGugunCode() {
        return gugunCode;
    }

    public void setGugunCode(int gugunCode) {
        this.gugunCode = gugunCode;
    }

    public String getGugunName() {
        return gugunName;
    }

    public void setGugunName(String gugunName) {
        this.gugunName = gugunName;
    }

    public int getSidoCode() {
        return sidoCode;
    }

    public void setSidoCode(int sidoCode) {
        this.sidoCode = sidoCode;
    }
}
