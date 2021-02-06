package com.example.apkapg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Studscreen extends AppCompatActivity {
    private DatabaseHandler objectDatabaseHandler;
    private RecyclerView objectRecyclerView;
    private RVAdapter objectRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studscreen);
        // set it inside text view to message
        TextView textView = findViewById(R.id.orderText);
        SharedPreferences getshared = getSharedPreferences("demo",MODE_PRIVATE);
        String userid=getshared.getString("str"," ");
        textView.setText("User-Id - "+userid);
        try{

            objectRecyclerView=findViewById(R.id.imagesRV);
            objectDatabaseHandler = new DatabaseHandler(this);



        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        objectRvAdapter = new RVAdapter(objectDatabaseHandler.getAllImageData());


        objectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        objectRecyclerView.setAdapter(objectRvAdapter);
    }


    public void logOut(View view) {
        Toast.makeText(this,"Logged out successfully", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);


    }

    public void about(View view) {
        Intent intent1 = new Intent(this, About.class);
        startActivity(intent1);

    }

    public void contact(View view) {
        Intent intent2 = new Intent(this, Contactus.class);
        startActivity(intent2);

    }
    public void bookPg(View view) {
        Intent intent3 = new Intent(this, Payment.class);
        startActivity(intent3);
    }
}