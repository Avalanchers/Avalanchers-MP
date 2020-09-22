package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LOGIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);

        Button b=(Button)findViewById(R.id.buttonreg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterPage();
            }
        });

    configNextButton();
    }

    public void RegisterPage(){
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }

    private void configNextButton(){
        Button nextbutton = (Button) findViewById(R.id.button);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LOGIN.this,LOGIN.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(new Intent(LOGIN.this , Home_Page.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(LOGIN.this,LOGIN.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY & Intent.FLAG_ACTIVITY_CLEAR_TOP & Intent.FLAG_ACTIVITY_NEW_TASK);
        finishAffinity();
        return;
    }
}