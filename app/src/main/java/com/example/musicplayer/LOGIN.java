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
<<<<<<< HEAD
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePge();
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
=======
>>>>>>> 9c628def3bd378543a05c7afc9be9efcbcdff693

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
                startActivity(new Intent(LOGIN.this , Home_Page.class));
            }
    });
    }

}