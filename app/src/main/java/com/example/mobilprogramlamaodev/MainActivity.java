package com.example.mobilprogramlamaodev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {
    public Intent i;
    SQLiteDatabase db,dbb;
    EditText kullaniciadi,sifre,email;
    Button giris,kayit;
    ImageView image1,image2,image3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            db=this.openOrCreateDatabase("Login",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar (id INTEGER PRIMARY KEY ,kullaniciadi VARCHAR, sifre VARCHAR, email VARCHAR )");
        }catch(Exception e){
            e.printStackTrace();
        }
        kullaniciadi=findViewById(R.id.kullaniciadi);
        sifre=findViewById(R.id.sifre);
        email=findViewById(R.id.eposta);

        giris=findViewById(R.id.girisbtn);
        kayit=findViewById(R.id.kayitbtn);

        image1=findViewById(R.id.img1);
        image2=findViewById(R.id.img2);
        image3=findViewById(R.id.img3);

        Animation anim11= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim1);
        image1.startAnimation(anim11);
        image2.startAnimation(anim11);
        image3.startAnimation(anim11);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad =kullaniciadi.getText().toString();
                String sifree=sifre.getText().toString();
                String mail=email.getText().toString();
                if(ad.length()==0 || sifree.length()==0 || mail.length()==0){

                    Toast.makeText(MainActivity.this, "Boş olamaz.", Toast.LENGTH_SHORT).show();
                }else{
                    int aa=1;
                    Cursor cursor=db.rawQuery("SELECT * FROM kullanicilar ",null);
                    int adIndex=cursor.getColumnIndex("kullaniciadi");
                    int sifreIndex=cursor.getColumnIndex("sifre");
                    int mailIndex=cursor.getColumnIndex("email");

                    while(cursor.moveToNext()) {
                        String a = cursor.getString(adIndex);
                        String b = cursor.getString(sifreIndex);
                        String c = cursor.getString(mailIndex);
                        if(ad.equals(a) && sifree.equals(b) && mail.equals(c) ){

                            aa=0;
                            i=new Intent(MainActivity.this,MainActivity2.class);
                            i.putExtra("nickname",a);
                            startActivity(i);

                            finish();
                            break;

                        }
                    }
                    if(aa==1){
                        Toast.makeText(MainActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count =1;
                String a = null;
                String b = null;
                String c ;
                String ad =kullaniciadi.getText().toString();
                String sifree=sifre.getText().toString();
                String mail=email.getText().toString();
                Cursor cursor=db.rawQuery("SELECT * FROM kullanicilar ",null);
                int adIndex=cursor.getColumnIndex("kullaniciadi");
                int sifreIndex=cursor.getColumnIndex("sifre");
                int mailIndex=cursor.getColumnIndex("email");
                while(cursor.moveToNext()) {
                    a = cursor.getString(adIndex);
                    b = cursor.getString(sifreIndex);
                    c = cursor.getString(mailIndex);
                    if(ad.equals(a)){
                        Toast.makeText(MainActivity.this, "Bu kullanıcı adı alınmış.", Toast.LENGTH_SHORT).show();
                        count=0;

                    }
                    else if(mail.equals(b)){
                        Toast.makeText(MainActivity.this, "Bu mail alınmış.", Toast.LENGTH_SHORT).show();

                        count=0;
                    }


                }

                if(ad.length()==0 || sifree.length()==0 || mail.length()==0){
                    Toast.makeText(MainActivity.this, "Boş olamaz.", Toast.LENGTH_SHORT).show();

                } else if(count==1){
                    db.execSQL("INSERT INTO kullanicilar(kullaniciadi,sifre,email) VALUES('"+ad+"','"+sifree+"','"+mail+"')");
                    Toast.makeText(MainActivity.this, "Kayıt başarılı.", Toast.LENGTH_SHORT).show();
                    kullaniciadi.setText("");
                    sifre.setText("");
                    email.setText("");


                }
            }
        });
    }
}