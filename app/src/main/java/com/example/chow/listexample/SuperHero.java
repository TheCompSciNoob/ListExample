package com.example.chow.listexample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by per6 on 9/27/17.
 */

public class SuperHero implements Parcelable {
    private String name;
    private String description;
    private int imageResouceID;

    public SuperHero(String name, String description, int imageResouceID) {
        this.name = name;
        this.description = description;
        this.imageResouceID = imageResouceID;
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

    public int getImageResouceID() {
        return imageResouceID;
    }

    public void setImageResouceID(int imageResouceID) {
        this.imageResouceID = imageResouceID;
    }

    @Override
    public String toString() {
        return name;
    }

    protected SuperHero(Parcel in) {
        name = in.readString();
        description = in.readString();
        imageResouceID = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(imageResouceID);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SuperHero> CREATOR = new Parcelable.Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };
}