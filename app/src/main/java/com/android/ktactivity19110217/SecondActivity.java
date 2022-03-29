package com.android.ktactivity19110217;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtInterest, txtAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String amountInterestString = intent.getStringExtra("INTEREST_MONEY");
        String amountMoneyString = intent.getStringExtra("AMOUNT_MONEY");
        txtInterest = findViewById(R.id.txtAmountInterest);
        txtAmount = findViewById(R.id.txtAmountMoney);
        txtInterest.setText(amountInterestString + " đ");
        txtAmount.setText(amountMoneyString + " đ");
    }

    public void takePicture(View view) {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
        finish();
    }
}