package com.hotstar.corngenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    TextView happy;
    EditText happiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        happy = findViewById(R.id.textss);
        happiness = findViewById(R.id.eta);
        Toast.makeText(this, "Sindhu", Toast.LENGTH_SHORT).show();
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu adf = new PopupMenu(SignUpActivity.this, happy);
                adf.getMenuInflater().inflate(R.menu.menu_latesh, adf.getMenu());


                adf.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.sin) {
                            Toast.makeText(SignUpActivity.this, "Sindhu", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this,OpenActivity.class));
                        }
                        return false;
                    }
                });
                adf.show();
            }
        });

        registerForContextMenu(happy);
        registerForContextMenu(happiness);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Select The Action");
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.call) {

        }
        return super.onContextItemSelected(item);
    }
}
