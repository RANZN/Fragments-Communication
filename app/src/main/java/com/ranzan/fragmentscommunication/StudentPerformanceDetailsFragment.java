package com.ranzan.fragmentscommunication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentPerformanceDetailsFragment extends Fragment {

    private Button mBtnNextPreview;
    private EditText mEtGrade;
    private EditText mEtPercentage;
    private String name;
    private int age;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name");
            age = getArguments().getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_performance_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    private void initViews(View view) {
        mBtnNextPreview = view.findViewById(R.id.btnNextPreview);
        mEtGrade = view.findViewById(R.id.etGrade);
        mEtPercentage = view.findViewById(R.id.etPercentage);
        mBtnNextPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = mEtGrade.getText().toString();
                String percentage = mEtPercentage.getText().toString();
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                Model model = new Model(name, grade, age, percentage);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
    }
}