package com.taiwantv.model;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by WilsonHuang-PC on 2016/3/8.
 */
public class Channel {
    private String name;
    private String videoUrl;
    private String category;
    private String cardImageUrl;
    private String bgImageUrl;
    private String studio;

    public Channel(String name, String videoUrl, String category, String cardImageUrl, String bgImageUrl, String studio) {
        this.name = name;
        this.videoUrl = videoUrl;
        this.category = category;
        this.cardImageUrl = cardImageUrl;
        this.bgImageUrl = bgImageUrl;
        this.studio = studio;
    }

    public Channel() {
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
}
