package com.taiwantv.view;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import android.util.Log;
import android.view.View;

import com.taiwantv.R;
import com.taiwantv.model.Channel;
import com.taiwantv.model.ChannelList;
import com.taiwantv.presenter.ChannelPresenter;

import java.util.List;

public class MainFragment extends BrowseFragment {
    private static final String TAG = "MianFragment";
    private BackgroundManager backgroundManager;
    private ArrayObjectAdapter mCategroyRowAdapter;//主畫面左邊分類欄位的Adapter
    private Drawable mDeufaultBackground;//預設背景
    private DisplayMetrics mDisplayMetrics;

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
        setOnSearchClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "clicked search");
            }
        });
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnItemViewSelectedListener(new ItemViewSelectedListener());

        ///////////
        //init row
        //////////
        List<Channel> channelList = ChannelList.setupChannels();

        mCategroyRowAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        ChannelPresenter channelPresenter = new ChannelPresenter();

        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(channelPresenter);
        for (int i = 0; i < channelList.size(); i++) {
            listRowAdapter.add(channelList.get(i));
        }
        HeaderItem headerItem = new HeaderItem(0, ChannelList.CATEGORY_LIST[0]);
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

        }
    }
}
