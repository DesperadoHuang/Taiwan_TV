package com.taiwantv.view.playback;

import android.app.Activity;
import android.os.Bundle;

import com.taiwantv.R;
import com.taiwantv.Tools;
import com.taiwantv.model.Channel;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

public class PlaybackOverlayActivity extends Activity implements PlaybackOverlayFragment.OnPlayPauseClickedListener {
    private static final String TAG = "PlaybackOverlayActivity";
    private VideoView vitamioVideoView;
    private Channel mSelectedChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        setContentView(R.layout.activity_playback);

        vitamioVideoView = (VideoView) findViewById(R.id.vitamio_videoView);
        mSelectedChannel = (Channel) getIntent().getSerializableExtra("Channel");
        Tools.showLog(TAG + mSelectedChannel.toString());

        vitamioVideoView.setVideoPath(mSelectedChannel.getVideoUrl_1());
        vitamioVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
            }
        });
    }

    @Override
    public void onFragmentPlayPause(Channel channel, int position, boolean playPause) {

    }
}
