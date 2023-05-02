package com.example.mobilprogramlamaodev;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolderSearch extends RecyclerView.ViewHolder{

    TextView text;
    ImageView img;
    public MyViewHolderSearch(@NonNull View itemView) {
        super(itemView);
        text=itemView.findViewById(R.id.textView2);
        img=itemView.findViewById(R.id.image22);
    }
}
