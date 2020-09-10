package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar=findViewById(R.id.progress_bar);


        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation();

    }
    public void progressAnimation(){
        ProgressBarAnimation animation=new ProgressBarAnimation(this,progressBar,0f,100f);
        animation.setDuration(3000);
        progressBar.setAnimation(animation);
    }
}