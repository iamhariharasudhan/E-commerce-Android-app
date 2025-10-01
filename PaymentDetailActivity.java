package com.payment.phonepe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentDetailActivity extends AppCompatActivity {

    private ImageView imageViewDetail;
    private TextView textViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        imageViewDetail = findViewById(R.id.imageViewDetail);
        textViewDetail = findViewById(R.id.textViewDetail);

        // Get the data passed from the intent
        Intent intent = getIntent();
        String optionName = intent.getStringExtra("optionName");
        int imageResId = intent.getIntExtra("imageResId", 0);

        // Set the received data to the views
        textViewDetail.setText(optionName);
        imageViewDetail.setImageResource(imageResId);
    }
}
