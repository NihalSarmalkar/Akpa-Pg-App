package com.example.apkapg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void placeOrder(View view)
    { // Build an intent to open another activity

        EditText editText1 = findViewById(R.id.editText);
        String msg = editText1.getText().toString();
        SharedPreferences shrd = getSharedPreferences("demo",MODE_PRIVATE);
        SharedPreferences.Editor editor =shrd.edit();
        editor.putString("str",msg);
        editor.apply();
        EditText edittext2=findViewById(R.id.editTextTextPassword);
        String password = edittext2.getText().toString();


        if(msg==null || msg.length()==0 )
        {
            Toast.makeText(this,"Incorrect User-Id", Toast.LENGTH_SHORT).show();
        }
        else if(password==null || password.length()==0 ){
            Toast.makeText(this,"Incorrect Password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"logged in successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Studscreen.class);
            //String message = "User-Id :"+msg;
            //intent.putExtra(MSG,message);
            startActivity(intent);
        }

    }
    public void ownerclick(View view)
    {
        Intent intent = new Intent(this, OwnerLogin.class);
        startActivity(intent);
    }
}