package com.taiwantv.model;

/**
 * Created by WilsonHuang-PC on 2016/3/8.
 */
public class Channel {
    private String name;
    private String videoUrl;
    private String category;


    public Channel(String name, String videoUrl, String category) {
        this.name = name;
        this.videoUrl = videoUrl;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
