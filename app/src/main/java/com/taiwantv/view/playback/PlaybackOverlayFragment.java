package com.taiwantv.view.playback;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v17.leanback.widget.ArrayObjectAdapter;

import com.taiwantv.model.Channel;

import java.util.ArrayList;

public class PlaybackOverlayFragment extends android.support.v17.leanback.app.PlaybackOverlayFragment {
    private static final String TAG = "PlaybackOverlayFragment";
    private static Context sContext;
    private ArrayObjectAdapter mRowAdapter;
    private ArrayObjectAdapter mPrimaryActionsAdapter;

    protected OnPlayPauseClickedListener mCallback;

    private ArrayList<Channel> mItems = new ArrayList<Channel>();
    private Channel mSelectedChannel;
    private int mCurrnetItem;

    private Handler mHandler;
    private Runnable mRunnable;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnPlayPauseClickedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implements OnPlayPauseClickedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sContext = getActivity();
        mItems = new ArrayList<Channel>();
        mSelectedChannel = (Channel) getActivity().getIntent().getSerializableExtra("Channel");
        mHandler = new Handler();
        setBackgroundType(PlaybackOverlayFragment.BG_LIGHT);
        setFadingEnabled(false);




    }

    public interface OnPlayPauseClickedListener {
        public void onFragmentPlayPause(Channel channel, int position, boolean playPause);
    }
}
