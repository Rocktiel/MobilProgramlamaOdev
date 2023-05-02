package com.example.mobilprogramlamaodev;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSearch extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSearch.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSearch newInstance(String param1, String param2) {
        FragmentSearch fragment = new FragmentSearch();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    List<person> personlist;
    View view;
    RecyclerView recyclerView;

    SearchView searchView;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView=view.findViewById(R.id.myrecyclersearch);

        personlist=new ArrayList<person>();
        personlist.add(new person("mstfyasin_61",R.drawable.asdf,R.drawable.resimsu));
        personlist.add(new person("mustsfakerem",R.drawable.asdf,R.drawable.resimkemre));
        personlist.add(new person("ilknuray10",R.drawable.asdf,R.drawable.resimiko));
        personlist.add(new person("keremsu",R.drawable.asdf,R.drawable.keremsu));
        personlist.add(new person("murphisttt",R.drawable.asdf,R.drawable.kubo));
        personlist.add(new person("defnebebek",R.drawable.asdf,R.drawable.defne));
        personlist.add(new person("kubikemre2861",R.drawable.asdf,R.drawable.kubikemre));

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        //recyclerView.setAdapter(new MyAdapterSearch(view.getContext(),personlist));

        searchView=view.findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }


        });
        return view;
    }
    private void filterList(String text) {
        List<person> filteredList=new ArrayList<>();
        for(person person1 : personlist){
            if(person1.getNickname().contains(text)){
                filteredList.add(person1);
            }
        }


            recyclerView.setAdapter(new MyAdapterSearch(view.getContext(),filteredList));


    }
}