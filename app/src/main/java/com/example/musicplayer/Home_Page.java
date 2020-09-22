package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        toPlayScreen();
        toPlayMusic2();
        toPlayMusic3();
        toPlayMusic4();
        toPlayMusic5();
        toPlayMusic6();
        toPlayMusic7();
        toPlayMusic8();
        toPlayMusic9();

        Button b=(Button)findViewById(R.id.logout);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutPage();
            }
        });

    }
    public void LogoutPage(){
        Intent intent=new Intent(this,LOGIN.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY & Intent.FLAG_ACTIVITY_CLEAR_TOP & Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    public void toPlayScreen(){
        View b=findViewById(R.id.songpicGrid);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,activity_music_player.class));
            }
        });
    }
    public void toPlayMusic2(){
        View b=findViewById(R.id.songGrid2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music2.class));
            }
        });
    }
    public void toPlayMusic3(){
        View b=findViewById(R.id.songGrid3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music3.class));
            }
        });
    }

    public void toPlayMusic4(){
        View b=findViewById(R.id.songGrid4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music4.class));
            }
        });
    }

    public void toPlayMusic5(){
        View b=findViewById(R.id.songGrid5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music5.class));
            }
        });
    }

    public void toPlayMusic6(){
        View b=findViewById(R.id.songGrid6);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music6.class));
            }
        });
    }

    public void toPlayMusic7(){
        View b=findViewById(R.id.songGrid7);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music7.class));
            }
        });
    }

    public void toPlayMusic8(){
        View b=findViewById(R.id.songGrid8);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music8.class));
            }
        });
    }

    public void toPlayMusic9(){
        View b=findViewById(R.id.songGrid9);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,music9.class));
            }
        });
    }

    private long backPressedTime;
    private Toast backToast;
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            Intent intent=new Intent(Home_Page.this,Home_Page.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY & Intent.FLAG_ACTIVITY_CLEAR_TOP & Intent.FLAG_ACTIVITY_NEW_TASK);
            finishAffinity();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}