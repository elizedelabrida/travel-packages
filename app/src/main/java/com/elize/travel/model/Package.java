package com.elize.travel.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Package implements Parcelable {
    private final String place;
    private final String image;
    private final int days;
    private final BigDecimal price;

    public Package(String place, String image, int days, BigDecimal price) {
        this.place = place;
        this.image = image;
        this.days = days;
        this.price = price;
    }

    private Package(Parcel in) {
        place = in.readString();
        image = in.readString();
        days = in.readInt();
        price = new BigDecimal(in.readString());
    }

    public static final Parcelable.Creator<Package>
            CREATOR = new Parcelable.Creator<Package>() {

        public Package createFromParcel(Parcel in) {
            return new Package(in);
        }

        public Package[] newArray(int size) {
            return new Package[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(place);
        out.writeString(image);
        out.writeInt(days);
        out.writeString(price.toPlainString());
    }
    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public int getDays() {
        return days;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
