package com.example.apkapg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    Context context;
    private static  String DATABASE_NAME="mydb.db";
    private static int DATABASE_VERSION=1;
    private static String createTableQuery="create table imageInfo (imageName TEXT"+",imageName1 TEXT "+",imageName2 TEXT "+",imageName3 TEXT "+",imageName4 TEXT "+
            ",image BLOB)";
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInByte;


    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(createTableQuery);
            Toast.makeText(context, "Table created successfully !", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(context,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storeImage(ModelClass objectModelClass)
    {
        try{
            SQLiteDatabase objectSQLiteDatabase = this.getWritableDatabase();
            Bitmap imageToStoreBitmap = objectModelClass.getImage();
            objectByteArrayOutputStream=new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,objectByteArrayOutputStream);
            imageInByte=objectByteArrayOutputStream.toByteArray();
            ContentValues objectContentValues = new ContentValues();
            objectContentValues.put("imageName",objectModelClass.getImageName());
            objectContentValues.put("imageName1",objectModelClass.getImageName1());
            objectContentValues.put("imageName2",objectModelClass.getImageName2());
            objectContentValues.put("imageName3",objectModelClass.getImageName3());
            objectContentValues.put("imageName4",objectModelClass.getImageName4());
            objectContentValues.put("image",imageInByte);

            long checkIfQueryRuns=objectSQLiteDatabase.insert("imageInfo",null,objectContentValues);
            if(checkIfQueryRuns!=-1)
            {
                Toast.makeText(context, "Data added into the  table", Toast.LENGTH_SHORT).show();
                objectSQLiteDatabase.close();
            }
            else{
                Toast.makeText(context, "Fail to add data into the table", Toast.LENGTH_SHORT).show();
            }


        }
        catch (Exception e){
            Toast.makeText(context,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public ArrayList<ModelClass> getAllImageData()
    {
        try{
            SQLiteDatabase objectSqlLiteDatabase=this.getReadableDatabase();
            ArrayList<ModelClass> objectModelClassList = new ArrayList<>();
            Cursor objectCursor=objectSqlLiteDatabase.rawQuery("select * from imageinfo",null);
            if(objectCursor.getCount() !=  0)
            {
                while(objectCursor.moveToNext())
                {
                    String nameOfImage=objectCursor.getString(0);
                    String nameOfImage1=objectCursor.getString(1);
                    String nameOfImage2=objectCursor.getString(2);
                    String nameOfImage3=objectCursor.getString(3);
                    String nameOfImage4=objectCursor.getString(4);
                    byte[] imageBytes=objectCursor.getBlob(5);
                    Bitmap objectBitmap = BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                    objectModelClassList.add(new ModelClass(nameOfImage,nameOfImage1,nameOfImage2,nameOfImage3,nameOfImage4,objectBitmap));


                }
                return objectModelClassList;

            }
            else
            {
                Toast.makeText(context, "No Values in data base", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch(Exception e)
        {
            Toast.makeText(context,e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }




}
