package com.taiwantv.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by WilsonHuang-PC on 2016/3/10.
 */
public class ChannelList {
    private static List<Channel> channelList;
    private static final String[] CATEGORY_LIST = {
            "新聞台"
    };

    private static final String[] CHANNEL_NAME_LIST = {
            "壹新聞", "年代新聞", "三立新聞", "中天新聞"
    };

    private static final String[] CHANNEL_VIDEO_URL = {
            "", "", "", ""
    };

    public static List<Channel> setupChannels() {
        channelList = new ArrayList<>();
        for (int i = 0; i < CHANNEL_NAME_LIST.length; i++) {
            channelList.add(buildChannelinfo(CHANNEL_NAME_LIST[i], CHANNEL_VIDEO_URL[i], CATEGORY_LIST[0]));
        }
        return channelList;
    }

    private static Channel buildChannelinfo(String name, String videoUrl, String category) {
        Channel channel = new Channel();
        channel.setName(name);
        channel.setVideoUrl(videoUrl);
        channel.setCategory(category);
        return channel;
    }
}
