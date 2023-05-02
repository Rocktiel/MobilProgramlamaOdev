package com.example.mobilprogramlamaodev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<person> people;

    public MyAdapter(Context context, List<person> people) {
        this.context = context;
        this.people = people;
    }

    public void setFilteredList(List<person> filteredList){
        this.people=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.homepage,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtnick.setText(people.get(position).getNickname());
        holder.imagepp.setImageResource(people.get(position).getImagepp());
        holder.image.setImageResource(people.get(position).getImage2());

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
