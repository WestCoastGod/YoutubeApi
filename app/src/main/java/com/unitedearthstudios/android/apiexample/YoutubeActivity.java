package com.unitedearthstudios.android.apiexample;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

        //Unique code assigned to application
        //essential strings for youtube api the code helps google keep
        //tabs on us using there code
    private String GOOGLE_API_KEY = "AIzaSyCiWdW2cj5YV2zFDhmvRML11Jf87wUSI6k";
    private String YOUTUBE_VIDEO_ID = "dVx_LEtquzc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        //In order to initialize player the key must be passed
        //Link to our youtube layout
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
    }

    //This methods will make our class happy please override just after implementing
    //"this" will be called if we are success full
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Toast.makeText(this, "Initialized Youtube Player Sucessfully", Toast.LENGTH_LONG).show();
        //set the code so that youtube know where to send us the
        // reults this code points where and what we want to play
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }

    }

    //these 2 methods tell us and android about the tracking of our video
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this, "Warror Action Playing", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this, "Warrior Action Paused", Toast.LENGTH_LONG).show();


        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }

    };//semi colon for validation

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity.this, "Watch To Support The NBA", Toast.LENGTH_LONG).show();


        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this, "Action Started", Toast.LENGTH_LONG).show();


        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    //If error tell us so !
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Initialize Youtube Player Failed", Toast.LENGTH_LONG).show();


    }
}
