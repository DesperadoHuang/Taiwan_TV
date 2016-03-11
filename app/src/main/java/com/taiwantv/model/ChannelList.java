package com.taiwantv.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by WilsonHuang-PC on 2016/3/10.
 */
public class ChannelList {
    private List<Channel> channelList;
    private static final String[] CATEGORY_LSIT = {

    };

    private static final String[] CHANNEL_NAME_LIST = {

    };

    private static final String[] CHANNEL_VIDEO_URL = {

    };

    private List<Channel> setupChannels() {
        channelList = new ArrayList<>();

        return channelList;
    }

    private Channel buildChannelinfo(String name, String videoUrl, String category) {
        Channel channel = new Channel();
        channel.setName(name);
        channel.setVideoUrl(videoUrl);
        channel.setCategory(category);
        return channel;
    }
}
