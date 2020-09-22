package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private Button submitR;
    private EditText username;
    private EditText pass;
    private EditText confpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        submitR=(Button)findViewById(R.id.buttonk);
        username=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);
        confpass=(EditText)findViewById(R.id.confpass);
        final AvalancheDB newuser=new AvalancheDB(this);

        submitR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (newuser.isEmpty(username))
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter Username !",Toast.LENGTH_LONG).show();
                    }
                    else if (newuser.isEmpty(pass))
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter Password !",Toast.LENGTH_LONG).show();
                    }
                    else if (newuser.isEmpty(confpass))
                    {
                        Toast.makeText(getApplicationContext(),"Please confirm your password !",Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (!pass.getText().toString().equals(confpass.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Your password doesn't match the confirmation !",Toast.LENGTH_LONG).show();
                        }
                        else {
                            newuser.createNewUser(username.getText().toString(),confpass.getText().toString());
                            Toast.makeText(getApplicationContext(),"User Added Successfully :) ",Toast.LENGTH_LONG).show();
                            openLoginPge();
                        }
                    }


            }
        });

    }
    private void openLoginPge() {
        Intent intent=new Intent(this,LOGIN.class);
        startActivity(intent);
    }
}