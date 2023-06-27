package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Addstudents extends AppCompatActivity {
    EditText Name,Email,ID,Course,DOB;
    Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudents);
        Name=findViewById(R.id.editTextName);
        Email=findViewById(R.id.editTextEmail);
        ID=findViewById(R.id.editTextMobile);
        Course=findViewById(R.id.editTextCourse);
        DOB=findViewById(R.id.editTextDOB);
        Submit=findViewById(R.id.Submit);




        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textName=Name.getText().toString();
                String textEmail=Email.getText().toString();
                String textID=ID.getText().toString();
                String textCourse=Course.getText().toString();
                String textDOB=DOB.getText().toString();

                dbhelper dbhelper=new dbhelper(Addstudents.this);
                dbhelper.addstudents(textName,textEmail,textID,textCourse,textDOB);
                Intent intent=new Intent(Addstudents.this,Homepage.class);
                startActivity(intent);
            }
        });
    }
}