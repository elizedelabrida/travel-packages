package com.elize.travel.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.elize.travel.R;
import com.elize.travel.model.Package;
import com.elize.travel.util.CurrencyUtil;
import com.elize.travel.util.DaysUtil;
import com.elize.travel.util.ResourcesUtil;

import java.util.List;

public class ListPackageAdapter extends BaseAdapter {

    private final List<Package> listPackages;
    private final Context context;

    public ListPackageAdapter(List<Package> listPackages, Context context) {
        this.listPackages = listPackages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listPackages.size();
    }

    @Override
    public Object getItem(int position) {
        return listPackages.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListPackageViewHolder holder;
        View view;
        if (convertView == null) {
            view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_package, parent, false);
            holder = new ListPackageViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ListPackageViewHolder) view.getTag();
        }
        fulfillView(position, holder);
        return view;
    }

    private void fulfillView(int position, ListPackageViewHolder holder) {
        Package travelPackage = listPackages.get(position);
        displayPlace(holder, travelPackage);
        displayImage(holder, travelPackage);
        displayDays(holder, travelPackage);
        displayPrice(holder, travelPackage);
    }

    private void displayPrice(ListPackageViewHolder holder, Package travelPackage) {
        String brazilianCurrency = CurrencyUtil.formatToBrazilianCurrency(travelPackage.getPrice());
        holder.textViewPrice.setText(brazilianCurrency);
    }

    private void displayDays(ListPackageViewHolder holder, Package travelPackage) {
        String daysText = DaysUtil.formatDaysToText(travelPackage.getDays());
        holder.textViewDays.setText(daysText);
    }

    private void displayImage(ListPackageViewHolder holder, Package travelPackage) {
        Drawable drawableImagePackage = ResourcesUtil.getDrawable(context, travelPackage.getImage());
        holder.imageViewPackage.setImageDrawable(drawableImagePackage);
    }

    private void displayPlace(ListPackageViewHolder holder, Package travelPackage) {
        holder.textViewPlace.setText(travelPackage.getPlace());
    }
}
