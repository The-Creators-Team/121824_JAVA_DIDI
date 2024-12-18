package com.example.javapracticeapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    // LiveData to hold the result
    private final MutableLiveData<String> _result = new MutableLiveData<>();
    public LiveData<String> result = _result;

    // Variables for the calculator logic
    private String currentInput = "";
    private String previousInput = "";
    private String operator = "";

    // Constructor (Initialization)
    public CalculatorViewModel() {
        _result.setValue("0");
    }

    // Method for handling digit button clicks
    public void onDigitClick(String digit) {
        if (currentInput.equals("0")) {
            currentInput = digit;
        } else {
            currentInput += digit;
        }
        _result.setValue(currentInput);
    }

    // Method for handling operator button clicks
    public void onOperatorClick(String op) {
        if (!currentInput.isEmpty()) {
            if (previousInput.isEmpty()) {
                previousInput = currentInput;
                currentInput = "";
            }
            operator = op;
        }
    }

    // Method for handling the equal button click
    public void onEqualClick() {
        if (!previousInput.isEmpty() && !currentInput.isEmpty() && !operator.isEmpty()) {
            Double num1 = null;
            Double num2 = null;

            try {
                num1 = Double.parseDouble(previousInput);
                num2 = Double.parseDouble(currentInput);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (num1 != null && num2 != null) {
                double result = 0.0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0.0) {
                            result = num1 / num2;
                        } else {
                            result = Double.NaN;  // Avoid division by zero
                        }
                        break;
                    default:
                        result = 0.0;
                }

                currentInput = String.valueOf(result);
                previousInput = "";
                operator = "";
                _result.setValue(currentInput);
            }
        }
    }

    // Method for handling the clear button click
    public void onClearClick() {
        currentInput = "";
        previousInput = "";
        operator = "";
        _result.setValue("0");
    }

    public LiveData<String> getResult(){
        return result;
    }
}
