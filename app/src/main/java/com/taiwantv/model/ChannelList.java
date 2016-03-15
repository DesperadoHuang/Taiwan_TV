package com.taiwantv.model;


import com.taiwantv.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WilsonHuang-PC on 2016/3/10.
 */
public class ChannelList {
    private static List<Channel> channelList;
    public static final String[] CHANNEL_CATEGORY_LIST = {
            "新聞台"
    };

    public static final String[] CHANNEL_NAME_LIST = {
            "壹新聞", "年代新聞", "三立新聞", "中天新聞"
    };

    public static final String[] CHANNEL_VIDEO_URL = {
            "",
            "",
            "",
            ""
    };

    public static final int[] CHANNEL_CARDIMAGE_ID = {
            R.drawable.next_tv,
            R.drawable.ear_news,
            R.drawable.set_news,
            R.drawable.cti_tv
    };
    public static final String[] CHANNEL_CARDIMAGE_URL = {
            "http://img.itver.cc/tv/NextTV.jpg",    //壹新聞
            "http://img.itver.cc/tv/ERA-News.jpg",  //年代新聞
            "http://img.itver.cc/tv/SET-News.jpg",  //三立新聞
            "http://img.itver.cc/tv/Cti-TV.jpg"     //中天新聞
    };

    public static List<Channel> setupChannels() {
        channelList = new ArrayList<>();
        for (int i = 0; i < CHANNEL_NAME_LIST.length; i++) {
            channelList.add(buildChannelinfo(CHANNEL_NAME_LIST[i], CHANNEL_VIDEO_URL[i],
                    CHANNEL_CARDIMAGE_URL[i], CHANNEL_CARDIMAGE_ID[i], CHANNEL_CATEGORY_LIST[0]));
        }
        return channelList;
    }

    private static Channel buildChannelinfo(String name, String videoUrl, String cardImageUrl,
                                            int cardImageId, String category) {
        Channel channel = new Channel();
        channel.setName(name);
        channel.setVideoUrl(videoUrl);
        channel.setCardImageUrl(cardImageUrl);
        channel.setCardImageId(cardImageId);
        channel.setCategory(category);
        return channel;
    }
}
