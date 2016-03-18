package com.taiwantv.view.main;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.DisplayMetrics;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.taiwantv.R;
import com.taiwantv.data.VideoDAO;
import com.taiwantv.model.Channel;
import com.taiwantv.model.ChannelList;
import com.taiwantv.presenter.ChannelPresenter;

import java.net.URI;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends BrowseFragment {
    private static final String TAG = "MianFragment";
    private BackgroundManager backgroundManager;
    private ArrayObjectAdapter mCategroyRowAdapter;//主畫面左邊分類欄位的Adapter
    private Drawable mDeufaultBackground;//預設背景
    private URI mBackgroundUri;
    private Timer mBackgroundTimer;
    private DisplayMetrics mDisplayMetrics;
    private final Handler handler = new Handler();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ////////////////////////////
        //prepare background manager
        ////////////////////////////
        backgroundManager = BackgroundManager.getInstance(getActivity());
        backgroundManager.attach(getActivity().getWindow());
        mDisplayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);

        ////////////////////
        //setup UI elements
        ////////////////////
        setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.tv_banner));//設定主畫面右上角Badge圖像
        setTitle("Taiwan TV");//設定主畫面右上角標題，若當Badge已設定，則以Badge為優先

        setHeadersState(HEADERS_ENABLED);//設定分類主選單顯示的方式
        setHeadersTransitionOnBackEnabled(true);//設定true，分類主選單的顯示方式才會啟用

        setBrandColor(getResources().getColor(R.color.header_background));//設定分類主選單的背景顏色

        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));//設定搜尋按鈕的背景顏色

        /////////////////////////
        //setup event listenters
        /////////////////////////
        //        setOnSearchClickedListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Log.i(TAG, "clicked search");
        //            }
        //        });
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnItemViewSelectedListener(new ItemViewSelectedListener());

        ///////////
        //init row
        //////////
        List<Channel> channelList = ChannelList.setupChannels();

        VideoDAO videoDAO = new VideoDAO(getActivity());
        for (int i = 0; i < channelList.size(); i++) {
            videoDAO.insert(channelList.get(i));
        }

        mCategroyRowAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        ChannelPresenter channelPresenter = new ChannelPresenter();

        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(channelPresenter);
        for (int i = 0; i < channelList.size(); i++) {
            listRowAdapter.add(channelList.get(i));
        }
        HeaderItem headerItem = new HeaderItem(0, ChannelList.CHANNEL_CATEGORY_LIST[0]);
        mCategroyRowAdapter.add(new ListRow(headerItem, listRowAdapter));


        setAdapter(mCategroyRowAdapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {

        }
    }

    private class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof Channel) {
                mBackgroundUri = ((Channel) item).getBgImageURI();
                startBackgroundTimerTask();
            }
        }
    }

    private void startBackgroundTimerTask() {
        if (mBackgroundTimer != null) {
            mBackgroundTimer.cancel();
        }
        mBackgroundTimer = new Timer();
        mBackgroundTimer.schedule(new UpdateBackgroundTask(), 1000);
    }


    private class UpdateBackgroundTask extends TimerTask {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (mBackgroundUri != null) {
                        updateBackground(mBackgroundUri.toString());
                    }
                }
            });
        }
    }

    private void updateBackground(String url) {
        int width = mDisplayMetrics.widthPixels;
        int height = mDisplayMetrics.heightPixels;
        Glide.with(getActivity())
                .load(url)
                .fitCenter()
                .into(new SimpleTarget<GlideDrawable>(width, height) {
                    @Override
                    public void onResourceReady(GlideDrawable resource,
                                                GlideAnimation<? super GlideDrawable> glideAnimation) {
                        backgroundManager.setDrawable(resource);
                    }
                });
        mBackgroundTimer.cancel();
    }
}
