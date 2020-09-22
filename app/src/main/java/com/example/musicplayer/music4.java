package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class music4 extends AppCompatActivity {

    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    Handler handler;
    Runnable runnable;
    boolean flag = false;
    ImageButton playicon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music4);

        playicon = findViewById(R.id.playButton);
        playicon.toString();
        playicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }

        });
        handler=new Handler();
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.godzzzilla);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                playCycle();
                mediaPlayer.start();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public  void playCycle()
    {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if(mediaPlayer.isPlaying())
        {
            runnable=new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        mediaPlayer.start();
        playCycle();
        playicon.setImageResource(R.drawable.ic_baseline_pause_24);

    }
    @Override
    protected void  onPause()
    {
        super.onPause();
        mediaPlayer.stop();
        playCycle();
        playicon.setImageResource(R.drawable.ic_baseline_play_arrow_24);
    }
    @Override
    public void  onDestroy()
    {
        super.onDestroy();
        playCycle();
        mediaPlayer.release();
        handler.removeCallbacks(runnable);
    }
    public void check(){
        if (flag == false)
        {
            flag = true;
            playicon.setImageResource(R.drawable.ic_baseline_pause_24);
            playCycle();
            mediaPlayer.start();
            playCycle();
        }
        else
        {
            flag = false;
            playicon.setImageResource(R.drawable.ic_baseline_play_arrow_24);
            mediaPlayer.pause();
            playCycle();
        }
    }
}