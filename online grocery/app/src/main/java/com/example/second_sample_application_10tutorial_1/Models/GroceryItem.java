package com.example.second_sample_application_10tutorial_1.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.second_sample_application_10tutorial_1.Utils;

import java.util.ArrayList;

public class GroceryItem implements Parcelable {

    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private String category;
    private int AvailableAmount;
    private double price;
    private int popularityPoint;
    private int userPoint;

    private ArrayList<Review> reviews;

    public GroceryItem(String name, String description, String imageUrl, String category, int availableAmount,
                       double price) {
        this.id = Utils.getID();
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        AvailableAmount = availableAmount;
        this.price = price;
        this.popularityPoint = 0;
        this.userPoint = 0;
        this.reviews = new ArrayList<>();
    }

    protected GroceryItem(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        category = in.readString();
        AvailableAmount = in.readInt();
        price = in.readDouble();
        popularityPoint = in.readInt();
        userPoint = in.readInt();
        reviews = in.createTypedArrayList(Review.CREATOR);
    }

    public static final Creator<GroceryItem> CREATOR = new Creator<GroceryItem>() {
        @Override
        public GroceryItem createFromParcel(Parcel in) {
            return new GroceryItem(in);
        }

        @Override
        public GroceryItem[] newArray(int size) {
            return new GroceryItem[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAvailableAmount() {
        return AvailableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        AvailableAmount = availableAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPopularityPoint() {
        return popularityPoint;
    }

    public void setPopularityPoint(int popularityPoint) {
        this.popularityPoint = popularityPoint;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                ", AvailableAmount=" + AvailableAmount +
                ", price=" + price +
                ", popularityPoint=" + popularityPoint +
                ", userPoint=" + userPoint +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(category);
        dest.writeInt(AvailableAmount);
        dest.writeDouble(price);
        dest.writeInt(popularityPoint);
        dest.writeInt(userPoint);
        dest.writeTypedList(reviews);
    }
}
