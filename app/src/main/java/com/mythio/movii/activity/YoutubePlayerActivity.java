package com.mythio.movii.activity;

import android.os.Bundle;


import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.mythio.movii.R;

import static com.mythio.movii.constant.constants.YOUTUBE_DEVELOPER_KEY;

public class YoutubePlayerActivity extends YouTubeFailureRecoveryActivity {

    private YouTubePlayerView playerView;
    private String url;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.player_youtube);

        url = getIntent().getStringExtra("EXTRAAA");

        playerView = findViewById(R.id.player);
        playerView.initialize(YOUTUBE_DEVELOPER_KEY, this);
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setFullscreen(true);
        player.setShowFullscreenButton(false);
        player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

        if (!wasRestored) {
            player.loadVideo(url);
        }
    }
}
