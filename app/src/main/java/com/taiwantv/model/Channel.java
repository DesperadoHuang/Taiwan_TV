package com.taiwantv.model;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by WilsonHuang-PC on 2016/3/8.
 */
public class Channel implements Serializable {
    private String name;
    private String videoUrl_1;
    private String videoUrl_2;
    private String category;
    private String cardImageUrl;
    private String bgImageUrl;
    private String studio;

    public Channel(String name, String videoUrl_1, String videoUrl_2, String category, String cardImageUrl, String bgImageUrl, String studio) {
        this.name = name;
        this.videoUrl_1 = videoUrl_1;
        this.videoUrl_2 = videoUrl_2;
        this.category = category;
        this.cardImageUrl = cardImageUrl;
        this.bgImageUrl = bgImageUrl;
        this.studio = studio;
    }

    public Channel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl_1() {
        return videoUrl_1;
    }

    public void setVideoUrl_1(String videoUrl_1) {
        this.videoUrl_1 = videoUrl_1;
    }

    public String getVideoUrl_2() {
        return videoUrl_2;
    }

    public void setVideoUrl_2(String videoUrl_2) {
        this.videoUrl_2 = videoUrl_2;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }

    public String getBgImageUrl() {
        return bgImageUrl;
    }

    public void setBgImageUrl(String bgImageUrl) {
        this.bgImageUrl = bgImageUrl;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public URI getBgImageURI() {
        try {
            return new URI(getBgImageUrl());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public URI getCardImageURI() {
        try {
            return new URI(getCardImageUrl());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", videoUrl_1='" + videoUrl_1 + '\'' +
                ", videoUrl_2='" + videoUrl_2 + '\'' +
                ", category='" + category + '\'' +
                ", cardImageUrl='" + cardImageUrl + '\'' +
                ", bgImageUrl='" + bgImageUrl + '\'' +
                ", studio='" + studio + '\'' +
                '}';
    }
}
