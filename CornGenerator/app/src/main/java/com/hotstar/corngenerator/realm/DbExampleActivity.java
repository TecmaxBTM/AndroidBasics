package com.hotstar.corngenerator.realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hotstar.corngenerator.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.realm.Realm;
import io.realm.RealmResults;

public class DbExampleActivity extends AppCompatActivity {
    Realm realm;
    EditText name, email, apss;

    Button get, save;
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$";
    private RealmResults<Customer> userRealmResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_example);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        apss = findViewById(R.id.etPassword);
        get = findViewById(R.id.btGetCount);
        save = findViewById(R.id.btSignUp);
        realm = Realm.getDefaultInstance();
        pattern = Pattern.compile(PASSWORD_PATTERN);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enName = name.getText().toString();
                String enEmail = email.getText().toString();
                String enPass = apss.getText().toString();
                matcher = pattern.matcher(enPass);
                if (enName.isEmpty()) {
                    Toast.makeText(DbExampleActivity.this, "Please Enter Valid Name", Toast.LENGTH_SHORT).show();
                } else if (enEmail.isEmpty()) {
                    Toast.makeText(DbExampleActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                } else if (enPass.isEmpty()) {
                    Toast.makeText(DbExampleActivity.this, "Please Enter Valid Mobile", Toast.LENGTH_SHORT).show();
                } else if (!matcher.matches()) {
                    Toast.makeText(DbExampleActivity.this, "Should Contain Unique", Toast.LENGTH_SHORT).show();
                } else {
                    Customer as = new Customer();
                    as.setName(enName);
                    as.setEmail(enEmail);
                    as.setPassword(enPass);
                    saveinDb(as);
                }
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
            }
        });
    }

    private void getUsers() {
        userRealmResults = realm.where(Customer.class).findAll();


        for (Customer use : userRealmResults) {
            String messg = use.getName() + " " + use.getPassword();
            Log.e("Mesafe", messg);
        }
        Toast.makeText(this, "Size is " + userRealmResults.size(), Toast.LENGTH_SHORT).show();

    }

    private void saveinDb(final Customer as) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number currentIdNum = realm.where(Customer.class).max("id");
                long nextId;
                if (currentIdNum == null) {
                    nextId = 1;
                } else {
                    nextId = currentIdNum.longValue() + 1;
                }
                as.setId(nextId);
                realm.insertOrUpdate(as);
                Toast.makeText(DbExampleActivity.this, "Inserted Success", Toast.LENGTH_SHORT).show();
                name.setText("");
                apss.setText("");
                email.setText("");
            }
        });
    }
}
