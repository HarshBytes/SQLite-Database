package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
RecyclerView recyclerView;
FloatingActionButton button;
    ArrayList<Datamodel_Student> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        recyclerView=findViewById(R.id.recyclerView);
        button=findViewById(R.id.floatingActionButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        arrayList.add(new Datamodel_Student("Harsh","18082001","PGDCA","18/08/2001","harsh.zala.3114@gmail.com"));


        dbhelper db=new dbhelper(this);
        arrayList=db.viewStudent();
        Adapter_Student adapter_student=new Adapter_Student(Homepage.this,arrayList);
        recyclerView.setAdapter(adapter_student);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Homepage.this,Addstudents.class);
                startActivity(intent);
            }
        });


    }
}