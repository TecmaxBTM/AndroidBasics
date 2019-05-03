package com.hotstar.corngenerator.recyclerview;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hotstar.corngenerator.R;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentVH> {
    ArrayList<Student> studentsList;

    public StudentAdapter(ArrayList<Student> stList) {
        studentsList = stList;
    }

    @Override
    public StudentAdapter.StudentVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_student_item,
                        viewGroup, false);
        return new StudentVH(v);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.StudentVH viewHolder, int i) {
            viewHolder.name.setText(studentsList.get(i).getName());
            viewHolder.age.setText(studentsList.get(i).getAge());
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    class StudentVH extends RecyclerView.ViewHolder {
        private TextView name, age;
        private AppCompatImageView call;

        public StudentVH(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.stName);
            age = itemView.findViewById(R.id.stAge);
            call = itemView.findViewById(R.id.stCall);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nois = studentsList.get(getAdapterPosition()).getMobile();
                    Toast.makeText(itemView.getContext(), nois, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
