package com.example.and10_fragmentadapter.melon;

public class MelonDTO {
    private String title , singer;
    private int imgProfile , rank;

    public MelonDTO(String title, String singer, int imgProfile, int rank) {
        this.title = title;
        this.singer = singer;
        this.imgProfile = imgProfile;
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
