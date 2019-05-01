package com.hotstar.corngenerator;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.SwitchCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button asb, login;
    EditText userName, password;
    RadioButton male, female;
    CheckBox tc;
    SeekBar volume;
    TextView volumeCount;
    SwitchCompat turnon;
    ListView listView;
    AppCompatSpinner spin;
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle as) {
        super.onCreate(as);
        setContentView(R.layout.activity_main);
        asb = findViewById(R.id.btSignUp);
        login = findViewById(R.id.btLogin);
        userName = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
        tc = findViewById(R.id.cbTerms);
        volume = findViewById(R.id.volume);
        listView = findViewById(R.id.countriesList);
        volumeCount = findViewById(R.id.volumeSelected);
        turnon = findViewById(R.id.switchs);
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        spin = findViewById(R.id.spin);

        int media_max_volume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume.setMax(media_max_volume);
        int media_current_volume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volume.setProgress(media_current_volume);
        volumeCount.setText("Volume is " + media_current_volume);

        asb.setOnClickListener(this);


        login.setOnClickListener(this);

        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this,
                            "Male Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });


        tc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = "";
                if (isChecked) {
                    msg = "Accepted Terms";
                } else {
                    msg = "Not Accepted Terms";
                }
                Toast.makeText(MainActivity.this,
                        msg, Toast.LENGTH_SHORT).show();
            }
        });

        turnon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = "";
                if (isChecked) {
                    msg = "Wifi On";
                } else {
                    msg = "Wifi Off";
                }
                Toast.makeText(MainActivity.this,
                        msg, Toast.LENGTH_SHORT).show();
            }
        });

        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int volume = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volume = progress;
                volumeCount.setText("Volume is " + volume);
                mAudioManager.setStreamVolume(
                        AudioManager.STREAM_MUSIC,
                        volume,
                        AudioManager.FLAG_SHOW_UI
                );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "On Start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Volume is " + volume, Toast.LENGTH_SHORT).show();
            }
        });

        String[] countries = {"India", "Pak", "Sri Lanka", "Aust"};
        ArrayAdapter<String> sad = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, countries);
        spin.setAdapter(sad);


        listView.setAdapter(sad);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String message = "";
                if (parent.getSelectedItem().toString().equalsIgnoreCase("india"))
                    message = "Delhi";
                else if (parent.getSelectedItem().toString().equalsIgnoreCase("Pak"))
                    message = "Islamabad";
                else if (parent.getSelectedItem().toString().equalsIgnoreCase("Sri Lanka"))
                    message = "Colombo";
                else
                    message = "Melbourne";

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_latesh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sin) {
            Toast.makeText(this, "Sindhu", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btSignUp:
                Intent acasd = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(acasd);
                break;
            case R.id.btLogin:
//                Intent acasd = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(acasd);
                String abd = userName.getText().toString();
                Toast.makeText(MainActivity.this, "Name is " + abd, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
