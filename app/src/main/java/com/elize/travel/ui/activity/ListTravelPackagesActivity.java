package com.elize.travel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.elize.travel.R;
import com.elize.travel.dao.PackageDAO;
import com.elize.travel.model.Package;
import com.elize.travel.ui.adapter.ListPackageAdapter;

import java.util.List;

import static com.elize.travel.ui.activity.PackageActivityConstants.PACKAGE_KEY;

public class ListTravelPackagesActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Packages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_travel_packages);
        setTitle(APPBAR_TITLE);
        configureList();
    }

    private void configureList() {
        ListView travelListView = findViewById(R.id.list_travel_packages_listView);
        final List<Package> travelPackagesList = new PackageDAO().listPackages();
        travelListView.setAdapter(new ListPackageAdapter(travelPackagesList, this));
        travelListView.setOnItemClickListener((adapterView, view, position, id) -> openPackageSummary(travelPackagesList, position));
    }

    private void openPackageSummary(List<Package> travelPackagesList, int position) {
        Intent intent = new Intent(this, PackageSummaryActivity.class);
        Package selectedTravelPackage = travelPackagesList.get(position);
        intent.putExtra(PACKAGE_KEY, selectedTravelPackage);
        startActivity(intent);
    }
}