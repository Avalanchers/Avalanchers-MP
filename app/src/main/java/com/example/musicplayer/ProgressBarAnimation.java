package com.example.musicplayer;


import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAnimation extends Animation {
    private Context context;
    private ProgressBar progressbar;
    private float from;
    private float to;
    public ProgressBarAnimation(Context context,ProgressBar progressbar,float from,float to){
        this.context=context;
        this.from=from;
        this.progressbar=progressbar;

        this.to=to;
    }
    @Override
    protected void applyTransformation (float inter, Transformation t){
         super.applyTransformation(inter,t);
         float value=from+(to-from)*inter;
         progressbar.setProgress((int)value);
         if(value==to)
         {
             context.startActivity(new Intent(context,LOGIN.class));
         }
    }

}
