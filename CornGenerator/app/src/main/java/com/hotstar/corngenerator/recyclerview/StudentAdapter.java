package com.hotstar.corngenerator.recyclerview;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hotstar.corngenerator.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentVH> {
    ArrayList<Student> studentsList;
    StudentClickListener callListenr;

    public StudentAdapter(ArrayList<Student> stList, StudentClickListener onclick) {
        studentsList = stList;
        callListenr = onclick;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
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
        if (!studentsList.get(i).getAddress().isEmpty()) {
            Picasso.with(viewHolder.name.getContext())
                    .load(studentsList.get(i).getAddress()).into(viewHolder.stImage);
        } else {
            Picasso.with(viewHolder.name.getContext())
                    .load(R.drawable.msj).into(viewHolder.stImage);
        }
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    class StudentVH extends RecyclerView.ViewHolder {
        private TextView name, age;
        private AppCompatImageView call;
        private AppCompatImageView stImage;

        public StudentVH(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.stName);
            age = itemView.findViewById(R.id.stAge);
            call = itemView.findViewById(R.id.stCall);
            stImage = itemView.findViewById(R.id.stImage);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCustomDialog(getAdapterPosition());
                }
            });

            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student add = studentsList.get(getAdapterPosition());
                    String nois = add.getMobile();
                    callListenr.onCallClick(add);
                    Toast.makeText(itemView.getContext(), nois, Toast.LENGTH_SHORT).show();
                }
            });
        }

        void showCustomDialog(final int position) {
            LayoutInflater factory = LayoutInflater.from(name.getContext());
            final View deleteDialogView = factory.inflate(R.layout.custom_dialog, null);
            final AlertDialog deleteDialog = new AlertDialog.Builder(name.getContext()).create();
            deleteDialog.setView(deleteDialogView);
            final EditText editName = deleteDialogView.findViewById(R.id.txt_dia);
            deleteDialogView.findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student add = studentsList.get(position);
                    add.setName(editName.getText().toString());
                    notifyDataSetChanged();
                    deleteDialog.dismiss();
                }
            });
            deleteDialogView.findViewById(R.id.btn_no).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteDialog.dismiss();
                }
            });
            deleteDialog.show();
        }
    }

    interface StudentClickListener {
        void onCallClick(Student object);
    }
}
