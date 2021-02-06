package com.example.apkapg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OwnerLogin extends AppCompatActivity {
    private EditText ET1;
    private EditText ET2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);
        ET1=findViewById(R.id.ownerID);
        ET2=findViewById(R.id.editTextNumberPassword);
    }
    public void ownerLogin(View view)
    {
        String msg = ET1.getText().toString();
        String password = ET2.getText().toString();
        if(msg==null || msg.length()==0 )
        {
            Toast.makeText(this,"Incorrect User-Id", Toast.LENGTH_SHORT).show();
        }
        else if(password==null || password.length()==0 ){
            Toast.makeText(this,"Incorrect Password", Toast.LENGTH_SHORT).show();
        }
        else{
            SharedPreferences shrd = getSharedPreferences("demo1",MODE_PRIVATE);
            SharedPreferences.Editor editor =shrd.edit();
            editor.putString("str1",msg);
            editor.apply();
            Toast.makeText(this,"Logged in successfully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Ownerscreen.class);
            startActivity(intent);
        }




    }
}