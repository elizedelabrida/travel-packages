package com.elize.travel.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.elize.travel.R;

public class ListPackageViewHolder {
    public final TextView textViewPrice;
    public final TextView textViewDays;
    public final ImageView imageViewPackage;
    public final TextView textViewPlace;

    public ListPackageViewHolder(View view) {
        textViewPrice =  view.findViewById(R.id.item_package_price);
        textViewDays = view.findViewById(R.id.item_package_days);
        imageViewPackage = view.findViewById(R.id.item_package_image);
        textViewPlace = view.findViewById(R.id.item_package_place);

    }
}
