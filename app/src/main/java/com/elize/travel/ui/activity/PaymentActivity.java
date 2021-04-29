package com.elize.travel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.elize.travel.R;
import com.elize.travel.model.Package;
import com.elize.travel.util.CurrencyUtil;

import static com.elize.travel.ui.activity.PackageActivityConstants.PACKAGE_KEY;

public class PaymentActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Payment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(APPBAR_TITLE);
        getReceivedPackage();
    }

    private void getReceivedPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {
            Package travelPackage = intent.getParcelableExtra(PACKAGE_KEY);
            displayPackageFinalPrice(travelPackage);
            configureButtonFinishPayment(travelPackage);
        }
    }

    private void configureButtonFinishPayment(Package travelPackage) {
        Button buttonFinishPayment = findViewById(R.id.payment_button_finish_payment);
        buttonFinishPayment.setOnClickListener(view -> openOrderSummary(travelPackage));
    }

    private void openOrderSummary(Package travelPackage) {
        Intent intentOrderSummary = new Intent(this, OrderSummaryActivity.class);
        intentOrderSummary.putExtra(PACKAGE_KEY, travelPackage);
        startActivity(intentOrderSummary);
    }

    private void displayPackageFinalPrice(Package travelPackage) {
        TextView textViewPackageFinalPrice = findViewById(R.id.payment_package_final_price);
        String brazilianPrice = CurrencyUtil.formatToBrazilianCurrency(travelPackage.getPrice());
        textViewPackageFinalPrice.setText(brazilianPrice);
    }
}