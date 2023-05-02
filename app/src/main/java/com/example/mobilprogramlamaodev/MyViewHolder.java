package com.example.mobilprogramlamaodev;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView txtnick;
    ImageView imagepp,image;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtnick=itemView.findViewById(R.id.textView);
        imagepp=itemView.findViewById(R.id.image2);
        image=itemView.findViewById(R.id.imageView);

    }


}
