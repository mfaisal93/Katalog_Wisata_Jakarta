package com.faisal.katalogwisatajakarta.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Wisata implements Parcelable {
    private int poster;
    private String judul;
    private String deskripsi;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
    }

    public Wisata() {
    }

    protected Wisata(Parcel in) {
        this.poster = in.readInt();
        this.judul = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Parcelable.Creator<Wisata> CREATOR = new Parcelable.Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel source) {
            return new Wisata(source);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };
}
