package com.elize.travel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.elize.travel.R;
import com.elize.travel.model.Package;
import com.elize.travel.util.CurrencyUtil;
import com.elize.travel.util.DateUtil;
import com.elize.travel.util.DaysUtil;
import com.elize.travel.util.ResourcesUtil;

import static com.elize.travel.ui.activity.PackageActivityConstants.PACKAGE_KEY;

public class PackageSummaryActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Package summary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_summary);
        setTitle(APPBAR_TITLE);
        getReceivedPackage();
    }

    private void getReceivedPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {
            Package travelPackage = intent.getParcelableExtra(PACKAGE_KEY);
            displayFields(travelPackage);
            configureButton(travelPackage);
        }
    }

    private void configureButton(Package travelPackage) {
        Button buttonPayment = findViewById(R.id.package_summary_button_payment);
        buttonPayment.setOnClickListener(view -> openPayment(travelPackage));
    }

    private void openPayment(Package travelPackage) {
        Intent intentPayment = new Intent(this, PaymentActivity.class);
        intentPayment.putExtra(PACKAGE_KEY, travelPackage);
        startActivity(intentPayment);
    }

    private void displayFields(Package travelPackage) {
        displayPlace(travelPackage);
        displayImage(travelPackage);
        displayDays(travelPackage);
        displayPrice(travelPackage);
        displayDate(travelPackage);
    }

    private void displayDate(Package packageDisplayed) {
        TextView textViewSummaryData = findViewById(R.id.package_summary_date);
        String travelDateFormatted = DateUtil.formatDatePeriodToText(packageDisplayed.getDays());
        textViewSummaryData.setText(travelDateFormatted);
    }

    private void displayPrice(Package packageDisplayed) {
        TextView textViewPrice = findViewById(R.id.package_summary_price);
        textViewPrice.setText(CurrencyUtil.formatToBrazilianCurrency(packageDisplayed.getPrice()));
    }

    private void displayDays(Package packageDisplayed) {
        TextView textViewDays = findViewById(R.id.package_summary_days);
        textViewDays.setText(DaysUtil.formatDaysToText(packageDisplayed.getDays()));
    }

    private void displayImage(Package packageDisplayed) {
        ImageView imageViewImage = findViewById(R.id.package_summary_image);
        imageViewImage.setImageDrawable(ResourcesUtil.getDrawable
                (this, packageDisplayed.getImage()));
    }

    private void displayPlace(Package packageDisplayed) {
        TextView textViewPlace = findViewById(R.id.package_summary_place);
        textViewPlace.setText(packageDisplayed.getPlace());
    }
}