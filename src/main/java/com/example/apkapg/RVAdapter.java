package com.example.apkapg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolderClass> {


    ArrayList<ModelClass> objectModelClassList;

    public RVAdapter(ArrayList<ModelClass> objectModelClassList) {
        this.objectModelClassList = objectModelClassList;
    }

    @NonNull
    @Override
    public RVViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RVViewHolderClass(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolderClass holder, int position) {
        ModelClass objectModelClass = objectModelClassList.get(position);

        holder.imageNameTV.setText("Pg/Hostel - "+objectModelClass.getImageName());
        holder.imageNameTV1.setText("Pg/Hostel Phone no. - "+objectModelClass.getImageName1());
        holder.imageNameTV2.setText("Pg/Hostel price - "+objectModelClass.getImageName2()+"Rs");
        holder.imageNameTV3.setText("Facilities available - "+objectModelClass.getImageName3());
        holder.imageNameTV4.setText("Address of Pg/Hostel - "+objectModelClass.getImageName4());
        holder.objectImageView.setImageBitmap(objectModelClass.getImage());


    }

    @Override
    public int getItemCount() {
        return objectModelClassList.size();
    }

    public static class RVViewHolderClass extends RecyclerView.ViewHolder {

        TextView imageNameTV;
        TextView imageNameTV1;
        TextView imageNameTV2;
        TextView imageNameTV3;
        TextView imageNameTV4;
        ImageView objectImageView;

        public RVViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageNameTV = itemView.findViewById(R.id.sr_imageDetailsTV);
            imageNameTV1 = itemView.findViewById(R.id.sr_imageDetailsTV1);
            imageNameTV2 = itemView.findViewById(R.id.sr_imageDetailsTV2);
            imageNameTV3 = itemView.findViewById(R.id.sr_imageDetailsTV3);
            imageNameTV4 = itemView.findViewById(R.id.sr_imageDetailsTV4);
            objectImageView = itemView.findViewById(R.id.sr_imageIV);


        }
    }

}

