package com.example.mobilprogramlamaodev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterSearch extends RecyclerView.Adapter<MyViewHolderSearch>{
    Context context;
    List<person> personn;

    public MyAdapterSearch(Context context, List<person> personn) {
        this.context = context;
        this.personn = personn;
    }

    public void setFilteredList(List<person> filteredList){
        this.personn=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderSearch(LayoutInflater.from(context).inflate(R.layout.searchpage,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderSearch holder, int position) {
        holder.text.setText(personn.get(position).getNickname());
        holder.img.setImageResource(personn.get(position).getImagepp());

    }

    @Override
    public int getItemCount()
    {

        return personn.size();
    }
}
