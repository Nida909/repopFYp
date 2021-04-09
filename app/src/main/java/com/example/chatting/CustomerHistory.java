package com.example.chatting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CustomerHistory extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    Activity activity;
    TextView tv;
    ArrayList<history1> customer=new ArrayList<history1>();
    private ProgressDialog progressDialog;
    ListView listView;
    String str1,str2,str3,str4,str5;
    String num,cID,milkmanId;
    int no=-1;
    FirebaseDatabase database;
    DatabaseReference ref;
    histories customhList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_history);
          Intent it=getIntent();
          num=it.getStringExtra("var");
           cID=it.getStringExtra("cID");
           milkmanId=it.getStringExtra("milkmanId");
        tv=(TextView)findViewById(R.id.txt);
        listView=(ListView)findViewById(R.id.list);
        activity = this;
         database = FirebaseDatabase.getInstance();
         ref = database.getReference().child("Orderlocation");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot h1: snapshot.getChildren()) {
                    //history1 h1=snapshot1.getValue(history1.class);
                   // no++;
                 String str=h1.child("CustomerContact").getValue().toString();

if(str.equals(num)) {
    history1 mObj = new history1(" " + h1.child("CustomerContact").getValue(), " " + h1.child("MilkmanLoc").getValue(), " " + h1.child("Price").getValue(), " " + h1.child("DropOffLoc").getValue());
    no = Integer.parseInt(h1.child("ID").getValue().toString());
    mObj.setCount(no);
    customer.add(mObj);
}

                }
                if(!customer.isEmpty())
                {
                   customhList = new histories(activity,customer);
                    listView.setAdapter(customhList);
                    customhList.notifyDataSetChanged();

                }else
                {
                    tv.setText("Your History is Empty");
                    tv.setTextSize(32);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String pickup=customer.get(position).getQuantity();
                    String dropoff=customer.get(position).getPrice();
                    int Count=customer.get(position).getCount();
                    //Toast.makeText(getApplicationContext(),"You Selected "+ss+ " as Country", Toast.LENGTH_LONG).show();
                    Intent intentt=new Intent(CustomerHistory.this, MapsActivity3.class);
                    intentt.putExtra("PickUp",pickup);
                    intentt.putExtra("DropOff",dropoff);
                    intentt.putExtra("milkmanId",milkmanId);
                    intentt.putExtra("customerId",cID);
                    intentt.putExtra("Count",Count);
                    startActivity(intentt);
                    Toast.makeText(getApplicationContext(),"You Selected "+customer.get(position).getName()+ " as Country", Toast.LENGTH_LONG).show();        }
            });

        }








    }

