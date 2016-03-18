package com.taiwantv.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by WilsonHuang-PC on 2016/3/10.
 */
public class ChannelList {
    private static List<Channel> channelList;


    public static final String[] CHANNEL_NAME_LIST = {
            "壹新聞",
            "年代新聞",
            "三立新聞",
            "東森新聞"
    };

    public static final String[] CHANNEL_VIDEO_URL = {
            "https://video11-lax.streamup.com/app/vm-ns-stream_aac/chunklist.m3u8",
            "https://video01-fra.streamup.com/app/wjj-eras-channel_aac/chunklist.m3u8",
            "https://video01-fra.streamup.com/app/mirror582sts-channel_aac/chunklist.m3u8",
            "http://ktv029.cdnak.ds.kylintv.net/nlds/kylin/etnews/as/live/etnews_4.m3u8"
    };

    public static final String[] CHANNEL_BG_IMAGE_URL = {
            "http://img.itver.cc/tv/NextTV.jpg",    //壹新聞
            "http://img.itver.cc/tv/ERA-News.jpg",  //年代新聞
            "http://img.itver.cc/tv/SET-News.jpg",  //三立新聞
            "http://img.itver.cc/tv/ETTV.jpg"     //東森新聞
    };

    public static final String[] CHANNEL_CARDIMAGE_URL = {
            "http://img.itver.cc/tv/NextTV.jpg",    //壹新聞
            "http://img.itver.cc/tv/ERA-News.jpg",  //年代新聞
            "http://img.itver.cc/tv/SET-News.jpg",  //三立新聞
            "http://img.itver.cc/tv/ETTV.jpg"     //東森新聞
    };

    public static final String[] CHANNEL_CATEGORY_LIST = {
            "新聞台",
            "新聞台",
            "新聞台",
            "新聞台"
    };
    public static final String[] CHANNEL_STUDIO = {
            "Streamup",
            "Streamup",
            "Streamup",
            "???"
    };

    public static List<Channel> setupChannels() {
        channelList = new ArrayList<>();
        for (int i = 0; i < CHANNEL_NAME_LIST.length; i++) {
            channelList.add(buildChannelinfo(CHANNEL_NAME_LIST[i], CHANNEL_VIDEO_URL[i], CHANNEL_CARDIMAGE_URL[i],
                    CHANNEL_BG_IMAGE_URL[i], CHANNEL_CATEGORY_LIST[i], CHANNEL_STUDIO[i]));
        }
        return channelList;
    }

    private static Channel buildChannelinfo(String name, String videoUrl, String cardImageUrl,
                                            String bgImageUrl, String category, String studio) {
        Channel channel = new Channel();
        channel.setName(name);
        channel.setVideoUrl(videoUrl);
        channel.setCardImageUrl(cardImageUrl);
        channel.setBgImageUrl(bgImageUrl);
        channel.setCategory(category);
        channel.setStudio(studio);
        return channel;
    }
}
