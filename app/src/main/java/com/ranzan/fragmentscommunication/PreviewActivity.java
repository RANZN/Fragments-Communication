package com.ranzan.fragmentscommunication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private TextView name;
    private TextView age;
    private TextView grade;
    private TextView percentage;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        Model model = (Model) getIntent().getSerializableExtra("model");
        name.setText(model.getName());
        age.setText(model.getAge() + "");
        grade.setText(model.getGrade());
        percentage.setText(model.getPercentage());
    }

    private void initViews() {
        name = findViewById(R.id.tvStudentName);
        age = findViewById(R.id.tvStudentAge);
        grade = findViewById(R.id.tvStudentGrade);
        percentage = findViewById(R.id.tvStudentPercentage);
    }
}