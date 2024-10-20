package com.training.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.training.mycalculator.databinding.ActivityMainBinding;
import com.training.mycalculator.databinding.ButtonsLayoutBinding;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ButtonsLayoutBinding layoutBinding;
    String [] newNumbers;
    ArrayList<String> operators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //For the included layout
        View view = binding.getRoot();
        layoutBinding = ButtonsLayoutBinding.bind(view);


        // Button Numbers
        layoutBinding.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"0");
            }
        });
        layoutBinding.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"1");
            }
        });
        layoutBinding.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"2");
            }
        });
        layoutBinding.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"3");
            }
        });
        layoutBinding.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"4");
            }
        });
        layoutBinding.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"5");
            }
        });
        layoutBinding.sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"6");
            }
        });
        layoutBinding.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"7");
            }
        });
        layoutBinding.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText() + "8");
            }
        });
        layoutBinding.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText(binding.displayBox.getText()+"9");
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////
        //Buttons Signs
        layoutBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlingOperations("+");
                operators.add("+");
            }
        });
        layoutBinding.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlingOperations("-");
                operators.add("-");


            }
        });
        layoutBinding.multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlingOperations("x");
                operators.add("x");
            }
        });
        layoutBinding.division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlingOperations("/");
                operators.add("/");
            }
        });
        layoutBinding.dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlingOperations(".");
                operators.add(".");
            }
        });
        layoutBinding.percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlingOperations("%");
                operators.add("%");
            }
        });
        layoutBinding.clearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.displayBox.setText("");
                operators.clear();

            }
        });
        layoutBinding.off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        layoutBinding.equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputInArrays();

            }
        });
    }






    //Functions
    //1.0,"+",1.0
    private double validation(String firstValue , String operator,String secondValue){
        double result = 0;
        switch (operator){
            case "+":
                result = Double.parseDouble(firstValue) + Double.parseDouble(secondValue);//result = 1+1 = 2.0
                break;
            case "-":
                result = Double.parseDouble(firstValue) - Double.parseDouble(secondValue);
                break;
            case "/":
                result = Double.parseDouble(firstValue) / Double.parseDouble(secondValue);
                break;
            case "x":
                result = Double.parseDouble(firstValue) * Double.parseDouble(secondValue);
                break;
            case "%":
                result = Double.parseDouble(firstValue) % Double.parseDouble(secondValue);
                break;

        }return result;
    }

    //Doneeeeeeeeeeee
    private void handlingOperations(String op){
        if (binding.displayBox.getText().equals("")){
            binding.displayBox.setText("SYNTAX ERROR");
        }else{
            binding.displayBox.append(op);
        }
    }
    private void getInputInArrays(){ //array for operators & array for numbers
        String input = binding.displayBox.getText().toString().trim();
        int lengthOfNumbers = input.length();
        int lengthOfOperators = operators.size();
        String newStr = "";

        for(int i = 0; i < lengthOfNumbers; i++){//length = 3
            if(input.charAt(i) == '+' ||input.charAt(i) == '-' ||input.charAt(i) == '/' ||input.charAt(i) == '%' ||input.charAt(i) == 'x'){
                newStr += " ";
            }else{
                newStr += input.charAt(i);
            }
        }
        String[] outputArray = newStr.split(" "); //["2" , "3"]

        //calculate in one line
        for (int i = 0; i < lengthOfOperators; i++){// 1
            double res = validation(outputArray[i],operators.get(i),outputArray[i+1]);
            outputArray[i+1] = String.valueOf(res);
        }
        binding.displayBox.setText(outputArray[outputArray.length-1]);
    }
}
