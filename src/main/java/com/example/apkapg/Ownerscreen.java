package com.example.apkapg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Ownerscreen extends AppCompatActivity {
    private EditText imageDetailsET;
    private EditText imageDetailsET1;
    private EditText imageDetailsET2;
    private EditText imageDetailsET3;
    private EditText imageDetailsET4;
    private ImageView objectImageView;
    private static final int PICK_IMAGE_REQUEST=100;
    private Uri imageFilePath;
    private Bitmap imageToStore;
    DatabaseHandler objectDatabaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerscreen);
        TextView textView = findViewById(R.id.ownerIDView);
        SharedPreferences getshared = getSharedPreferences("demo1",MODE_PRIVATE);
        String userid=getshared.getString("str1"," ");
        textView.setText("User-Id - "+userid);


        try{
            imageDetailsET=findViewById(R.id.imageNameET);
            imageDetailsET1=findViewById(R.id.imageNameET1);
            imageDetailsET2=findViewById(R.id.imageNameET2);
            imageDetailsET3=findViewById(R.id.imageNameET3);
            imageDetailsET4=findViewById(R.id.imageNameET4);
            objectImageView=findViewById(R.id.image);
            objectDatabaseHandler = new DatabaseHandler(this);

        }
        catch(Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void chooseImage(View objectView)
    {
        try{
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");
            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,PICK_IMAGE_REQUEST);


        }
        catch(Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null)
            {
                imageFilePath=data.getData();
                imageToStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);
                objectImageView.setImageBitmap(imageToStore);
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    public void storeImage(View view)
    {
        try
        {
            if(!imageDetailsET.getText().toString().isEmpty() && !imageDetailsET1.getText().toString().isEmpty() && !imageDetailsET2.getText().toString().isEmpty() && !imageDetailsET3.getText().toString().isEmpty() && !imageDetailsET4.getText().toString().isEmpty() &&objectImageView.getDrawable()!=null && imageToStore!=null) {
                objectDatabaseHandler.storeImage(new ModelClass(imageDetailsET.getText().toString(),imageDetailsET1.getText().toString(),imageDetailsET2.getText().toString(),imageDetailsET3.getText().toString(),imageDetailsET4.getText().toString(),imageToStore));

            }
            else {
                Toast.makeText(this, "NOTE : Please select image name and image ", Toast.LENGTH_SHORT).show();
            }


        }
        catch(Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

}