package com.android.ktactivity19110217;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int REQUEST_CODE = 1;
    private EditText editMoney, editInterest, editMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMoney  = findViewById(R.id.editMoney);
        editInterest = findViewById(R.id.editInterest);
        editMonth = findViewById(R.id.editMonth);
    }
    public void launchSecondActivity(View view){
    if((editMoney.getText().length() > 0) && (editInterest.getText().length() > 0)
            && (editMonth.getText().length() > 0) ){
        int money = Integer.parseInt(editMoney.getText().toString());
        int interest = Integer.parseInt(editInterest.getText().toString());
        int month = Integer.parseInt(editMonth.getText().toString());
        int amountInterest = money * interest/100 * ((month*30)/360);
        int amountMoney = money + amountInterest;
        String amountInterestString =  String.valueOf(amountInterest);
        String amountMoneyString = String.valueOf(amountMoney);
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("INTEREST_MONEY",amountInterestString);
        intent.putExtra("AMOUNT_MONEY",amountMoneyString);
        startActivityForResult(intent,REQUEST_CODE);
    }
    else {
        Toast toast= Toast.makeText(MainActivity.this,"Vui lòng nhập đầy đủ thông tin!",Toast.LENGTH_LONG);
        toast.show();
    }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}