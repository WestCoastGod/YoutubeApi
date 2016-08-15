package com.unitedearthstudios.android.apiexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnPlayVideo;
        Button btnPlayList;

        btnPlayVideo = (Button)findViewById(R.id.btnPlayVideo);
        btnPlayList = (Button)findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Unique code assigned to application
        //essential strings for youtube api the code helps google keep
        //tabs on us using there code. Please keep variables local for memory purposes.
        String GOOGLE_API_KEY = "AIzaSyCiWdW2cj5YV2zFDhmvRML11Jf87wUSI6k";
        String YOUTUBE_VIDEO_ID = "dVx_LEtquzc";
        String YOUTUBE_PLAYLIST = "KekO2zQ2fuE&list=LLeYc_OjHs3QNxIjti2whKzg";
        Intent intent = null;
        //switch statement for our 2 video options (Activities)
        switch (view.getId()){

            //Tell each intent take us to our specified keys and ids
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;

            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;

            default:
        }

        //it is good programming practice to always check for null
        if(intent!=null){
            startActivity(intent);


        }

    }
}
