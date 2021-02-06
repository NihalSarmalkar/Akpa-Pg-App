package com.example.apkapg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
    }
    public void backContact(View view)
    {
        Intent intent13 = new Intent(this, Studscreen.class);
        startActivity(intent13);

    }
}