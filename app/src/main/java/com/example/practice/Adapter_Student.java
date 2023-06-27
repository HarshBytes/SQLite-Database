package com.example.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice.Datamodel_Student;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Student extends RecyclerView.Adapter<Adapter_Student.Viewholder> {
    Context context;
    ArrayList<Datamodel_Student> arrayList;

    Adapter_Student(Context context, ArrayList<Datamodel_Student> arrayList){
        this.context = context;
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.Name.setText(arrayList.get(position).Name);
        holder.Email.setText(arrayList.get(position).Email);
        holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper db=new dbhelper(context);
                boolean isDeleted = db.deleteStudent(arrayList.get(holder.getAdapterPosition()).getEnrollment());

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView Name, Email;
        ImageView editIcon,deleteIcon;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.textName);
            Email=itemView.findViewById(R.id.textEmail);
            deleteIcon=itemView.findViewById(R.id.deleteIcon);
            editIcon=itemView.findViewById(R.id.editIcon);
        }
    }
}
