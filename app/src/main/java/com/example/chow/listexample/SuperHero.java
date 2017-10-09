package com.example.chow.listexample;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by per6 on 9/27/17.
 */

public class SuperHero implements Parcelable, Comparable<SuperHero> {
    private String name;
    private String description;
    private int imageResouceID;
    private int ranking;

    public SuperHero(String name, String description, int ranking, int imageResouceID) {
        this.name = name;
        this.description = description;
        this.ranking = ranking;
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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return name;
    }

    protected SuperHero(Parcel in) {
        name = in.readString();
        description = in.readString();
        imageResouceID = in.readInt();
        ranking = in.readInt();
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
        dest.writeInt(ranking);
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

    @Override
    public int compareTo(@NonNull SuperHero other) {
        return this.ranking - other.ranking;
    }
}