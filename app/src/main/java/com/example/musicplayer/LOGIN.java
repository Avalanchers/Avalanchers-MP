package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LOGIN extends AppCompatActivity {
    private Button submitL;
    private EditText UserN;
    private EditText UserP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);



        submitL=(Button)findViewById(R.id.button);
        UserN=(EditText)findViewById(R.id.name);
        UserP=(EditText)findViewById(R.id.pass);
        final AvalancheDB ExsistUser=new AvalancheDB(this);


        submitL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ExsistUser.VerifyUser(UserN.getText().toString(),UserP.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Logged in successfully :)",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LOGIN.this , Home_Page.class));
                }
                else{
                    
                    Toast.makeText(getApplicationContext(),"SomeThing went Wrong !",Toast.LENGTH_LONG).show();
                }
                

            }

        });


        Button reg=(Button)findViewById(R.id.buttonreg);
        reg.setOnClickListener(new View.OnClickListener() {
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
        submitL.setOnClickListener(new View.OnClickListener() {
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