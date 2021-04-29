package com.elize.travel.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.elize.travel.R;
import com.elize.travel.model.Package;
import com.elize.travel.util.CurrencyUtil;
import com.elize.travel.util.DateUtil;
import com.elize.travel.util.ResourcesUtil;

import static com.elize.travel.ui.activity.PackageActivityConstants.PACKAGE_KEY;

public class OrderSummaryActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Order summary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        setTitle(APPBAR_TITLE);
        getReceivedPackage();
    }

    private void getReceivedPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {
            Package travelPackage = intent.getParcelableExtra(PACKAGE_KEY);
            displayFields(travelPackage);
        }
    }

    private void displayFields(Package travelPackage) {
        displayImage(travelPackage);
        displayPlace(travelPackage);
        displayDate(travelPackage);
        displayPackageFinalPrice(travelPackage);
    }

    private void displayDate(Package travelPackage) {
        TextView textViewDays = findViewById(R.id.order_summary_date);
        String daysText = DateUtil.formatDatePeriodToText(travelPackage.getDays());
        textViewDays.setText(daysText);
    }

    private void displayImage(Package travelPackage) {
        ImageView imageViewPackage = findViewById(R.id.order_summary_package_image);
        Drawable drawableImagePackage = ResourcesUtil
                .getDrawable(this, travelPackage.getImage());
        imageViewPackage.setImageDrawable(drawableImagePackage);
    }

    private void displayPlace(Package travelPackage) {
        TextView textViewPlace = findViewById(R.id.order_summary_place);
        textViewPlace.setText(travelPackage.getPlace());
    }

    private void displayPackageFinalPrice(Package travelPackage) {
        TextView textViewPackageFinalPrice = findViewById(R.id.order_summary_final_price);
        String brazilianPrice = CurrencyUtil.formatToBrazilianCurrency(travelPackage.getPrice());
        textViewPackageFinalPrice.setText(brazilianPrice);
    }
}