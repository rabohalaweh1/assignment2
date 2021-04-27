package edu.cs.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;


public class MainActivity2 extends AppCompatActivity {
    private EditText workEdit;
    private EditText educationEdit;
    private SharedPreferences pre;
    private SharedPreferences.Editor editor;
    public static final String Edu= "Education";
    public static final String Work = "Work";
    String educationString,WorkString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupViews();
        setupSharedPrefs();
        loadPrefs();
    }



    public void btnSaveOnClick(View v) {
        educationString = workEdit.getText().toString();
        WorkString = workEdit.getText().toString();

        editor.putString(Edu, educationString);
        editor.putString(Work, WorkString);
        editor.commit();
    }


    private  void setupViews(){
        workEdit = findViewById(R.id.workEdit);
        educationEdit = findViewById(R.id.educationEdit);

    }

    private  void setupSharedPrefs(){
        pre = PreferenceManager.getDefaultSharedPreferences(this );
        editor = pre .edit();
    }

    private void loadPrefs(){
        educationString = pre.getString(Edu, "");
        WorkString = pre.getString(Work, "");

        educationEdit.setText(educationString);
        workEdit.setText(WorkString);


    }
}
