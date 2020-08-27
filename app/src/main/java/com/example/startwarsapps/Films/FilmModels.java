package com.example.startwarsapps.Films;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FilmModels {


    @Expose
    @SerializedName("results")
    private ArrayList<Results> results;
    @Expose
    @SerializedName("count")
    private int count;

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
