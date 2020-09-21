package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LOGIN extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);



        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configNextButton();
            }

        });
        Button b=(Button)findViewById(R.id.buttonreg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterPage();
            }
        });

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
                startActivity(new Intent(LOGIN.this , Home_Page.class));
            }
    });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}