package com.example.javapracticeapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.javapracticeapplication.CalculatorViewModel;
import com.example.javapracticeapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final CalculatorViewModel calculatorViewModel = new CalculatorViewModel(); // ViewModel initialization in Java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        calculatorViewModel.getResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String result) {
                binding.tvDisplay.setText(result);  // Access the TextView via View Binding
            }
        });


        binding.btn0.setOnClickListener(this::onDigitClick);
        binding.btn1.setOnClickListener(this::onDigitClick);
        binding.btn2.setOnClickListener(this::onDigitClick);
        binding.btn3.setOnClickListener(this::onDigitClick);
        binding.btn4.setOnClickListener(this::onDigitClick);
        binding.btn5.setOnClickListener(this::onDigitClick);
        binding.btn6.setOnClickListener(this::onDigitClick);
        binding.btn7.setOnClickListener(this::onDigitClick);
        binding.btn8.setOnClickListener(this::onDigitClick);
        binding.btn9.setOnClickListener(this::onDigitClick);
        binding.btnAdd.setOnClickListener(this::onOperatorClick);
        binding.btnSubtract.setOnClickListener(this::onOperatorClick);
        binding.btnMultiply.setOnClickListener(this::onOperatorClick);
        binding.btnDivide.setOnClickListener(this::onOperatorClick);
        binding.btnClear.setOnClickListener(this::onClearClick);
        binding.btnEqual.setOnClickListener(this::onEqualClick);
    }


    public void onDigitClick(View view) {
        Button button = (Button) view;
        calculatorViewModel.onDigitClick(button.getText().toString());
    }


    public void onOperatorClick(View view) {
        Button button = (Button) view;
        calculatorViewModel.onOperatorClick(button.getText().toString());
    }


    public void onEqualClick(View view) {
        calculatorViewModel.onEqualClick();
    }


    public void onClearClick(View view) {
        calculatorViewModel.onClearClick();
    }
}
