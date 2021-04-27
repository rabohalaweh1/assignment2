package edu.cs.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText addressEdit;
    private EditText phoneEdit;
    private EditText ageEdit;
    private EditText hobEdit;
    private RadioGroup rdg;
    private Button save;
    private Button next;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public static final String Name = "Name";
    public static final String Email= "Email";
    public static final String Address = "Address";
    public static final String Gender = "Gender";
    public static final String Phone = "Phone";
    public static final String Age = "Age";
    public static final String Language = "Language";
    public static final String Hobbies = "Hobbies" ;
    String nameStr,stringEmail,stringAddress,stringGender,stringPhone,stringAge,stringLanguage,stringHob;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupSharedPrefs();
        loadPrefs();
    }
    public void btnSaveOnClick(View v) {
        nameStr = nameEdit.getText().toString();
        stringEmail = emailEdit.getText().toString();
        stringAddress = addressEdit.getText().toString();
//                    genderStr = rdg
        stringPhone = phoneEdit.getText().toString();
        stringAge = ageEdit.getText().toString();
        stringLanguage = spinner.getSelectedItem().toString();
        stringHob = hobEdit.getText().toString();

        editor.putString(Name, nameStr);
        editor.putString(Email, stringEmail);
        editor.putString(Address,stringAddress);
        editor.putString(Gender,stringGender);
        editor.putString(Phone,stringPhone);
        editor.putString(Age,stringAge);
        editor.putString(Language,stringLanguage);
        editor.putString(Hobbies,stringHob);
        editor.commit();
    }

    public void btnNextOnClick(View view) {
        Intent intent = new Intent(MainActivity.this , MainActivity2.class);
        startActivity(intent);
    }

    private  void setupViews(){
        nameEdit = findViewById(R.id.nameEdit);
        emailEdit = findViewById(R.id.emailEdit);
        addressEdit = findViewById(R.id.addressEdit);
        phoneEdit = findViewById(R.id.phoneEdit);
        ageEdit = findViewById(R.id.ageEdit);
        hobEdit = findViewById(R.id.hobEdit);
        RadioGroup rdg = (RadioGroup) findViewById(R.id.rdg);
        spinner = (Spinner) findViewById(R.id.spinerEdit);
        PopulateSpinner();
        save = findViewById(R.id.savebotton);
        next = findViewById(R.id.nextBotton);
    }
    private  void setupSharedPrefs(){
        prefs = PreferenceManager.getDefaultSharedPreferences(this );
        editor = prefs.edit();
    }
    private void loadPrefs(){
        nameStr = prefs.getString(Name, "");
        stringEmail = prefs.getString(Email, "");
        stringAddress = prefs.getString(Address,"");
        stringGender = prefs.getString(Gender,"");
        stringPhone = prefs.getString(Phone, "");
        stringAge = prefs.getString(Age, "");
        stringLanguage = prefs.getString(Language,"");
        stringHob = prefs.getString(Language,"");

        nameEdit.setText(nameStr);
        emailEdit.setText(stringEmail);
        addressEdit.setText(stringAddress);
        phoneEdit.setText(stringPhone);
        ageEdit.setText(stringAge);
        spinner.setSelected(Boolean.parseBoolean(stringLanguage));
        hobEdit.setText(stringHob);


    }
    private void PopulateSpinner() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Italian");
        data.add("Arabic");
        data.add("Hebrew");
        data.add("English");
        data.add("Spanish");
        data.add("French");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data  );
        spinner.setAdapter(adapter);
    }
}