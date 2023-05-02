package com.example.mobilprogramlamaodev;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProfile newInstance(String param1, String param2) {
        FragmentProfile fragment = new FragmentProfile();
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

    TextView txt1,txt2,txt3;
    EditText eskisifre,yenisifre;
    Button btn;

    SQLiteDatabase dbb;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        txt1=view.findViewById(R.id.textView3);
        //txt2=view.findViewById(R.id.textView4);
        txt3=view.findViewById(R.id.textView5);
        eskisifre=view.findViewById(R.id.eskisifre);
        yenisifre=view.findViewById(R.id.yenisifre);
        btn=view.findViewById(R.id.button);



        try{

            dbb=view.getContext().openOrCreateDatabase("Login",MODE_PRIVATE,null);
            dbb.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar (id INTEGER PRIMARY KEY ,kullaniciadi VARCHAR, sifre VARCHAR, email VARCHAR )");
        }catch(Exception e){
            e.printStackTrace();
        }
        Intent ii=getActivity().getIntent();
        String ka=ii.getStringExtra("nickname");


        Cursor cursor=dbb.rawQuery("SELECT * FROM kullanicilar ",null);
        int adIndex=cursor.getColumnIndex("kullaniciadi");
        int sifreIndex=cursor.getColumnIndex("sifre");
        int mailIndex=cursor.getColumnIndex("email");
        while(cursor.moveToNext()) {
            String a = cursor.getString(adIndex);
            String b = cursor.getString(sifreIndex);
            String c = cursor.getString(mailIndex);

            if(a.equals(ka)){
                txt1.setText(a);
                //txt2.setText(b);
                txt3.setText(c);
                //txt4.setText(b);
                break;
            }
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bb = cursor.getString(sifreIndex);
                String a=eskisifre.getText().toString();
                String b=yenisifre.getText().toString();
                if(a.length()==0 || b.length()==0){
                    Toast.makeText(view.getContext(), "Boş olamaz.", Toast.LENGTH_SHORT).show();
                }else if(!bb.equals(a)) {
                    Toast.makeText(view.getContext(), "Eski şifreniz yanlış.", Toast.LENGTH_SHORT).show();
                }else {

                    eskisifre.setText("");
                    yenisifre.setText("");
                    Toast.makeText(view.getContext(), "Şifre değiştirme başarılı.", Toast.LENGTH_SHORT).show();
                    dbb.execSQL("UPDATE kullanicilar SET sifre='"+b+"' WHERE kullaniciadi=('"+txt1.getText().toString()+"')");
                }
            }
        });

        return view;
    }
}