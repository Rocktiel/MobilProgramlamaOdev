package com.example.mobilprogramlamaodev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.myrecycler);
        List<person> person=new ArrayList<person>();

        person.add(new person("mstfyasin_61",R.drawable.asdf,R.drawable.resimsu));
        person.add(new person("mustsfakerem",R.drawable.asdf,R.drawable.resimkemre));
        person.add(new person("ilknuray10",R.drawable.asdf,R.drawable.resimiko));
        person.add(new person("keremsu",R.drawable.asdf,R.drawable.keremsu));
        person.add(new person("murphisttt",R.drawable.asdf,R.drawable.kubo));
        person.add(new person("defnebebek",R.drawable.asdf,R.drawable.defne));
        person.add(new person("kubikemre2861",R.drawable.asdf,R.drawable.kubikemre));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new MyAdapter(view.getContext(),person));


        return view;
    }
}