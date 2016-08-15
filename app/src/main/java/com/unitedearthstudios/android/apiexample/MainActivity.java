package com.unitedearthstudios.android.apiexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPlaySingle;
    private Button btnStandAlone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlaySingle = (Button)findViewById(R.id.btnPlaySingle);
        btnStandAlone = (Button)findViewById(R.id.btnStandAlone);

        btnPlaySingle.setOnClickListener(this);
        btnStandAlone.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){

            //this time we pass the class
            case R.id.btnPlaySingle:
                intent = new Intent(MainActivity.this, YoutubeActivity.class);
                break;

            case R.id.btnStandAlone:
                intent = new Intent(MainActivity.this, StandaloneActivity.class);

                break;

            default:
                //just to put
        }

        if(intent!=null){
            startActivity(intent);
        }


    }
}
