package com.example.startwarsapps.Films;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Results implements Parcelable {
    @Expose
    @SerializedName("url")
    private String url;
    @Expose
    @SerializedName("edited")
    private String edited;
    @Expose
    @SerializedName("created")
    private String created;
    @Expose
    @SerializedName("species")
    private ArrayList<String> species;
    @Expose
    @SerializedName("vehicles")
    private ArrayList<String> vehicles;
    @Expose
    @SerializedName("starships")
    private ArrayList<String> starships;
    @Expose
    @SerializedName("planets")
    private ArrayList<String> planets;
    @Expose
    @SerializedName("characters")
    private ArrayList<String> characters;
    @Expose
    @SerializedName("release_date")
    private String releaseDate;
    @Expose
    @SerializedName("producer")
    private String producer;
    @Expose
    @SerializedName("director")
    private String director;
    @Expose
    @SerializedName("opening_crawl")
    private String openingCrawl;
    @Expose
    @SerializedName("episode_id")
    private int episodeId;
    @Expose
    @SerializedName("title")
    private String title;

    protected Results(Parcel in) {
        url = in.readString();
        edited = in.readString();
        created = in.readString();
        species = in.createStringArrayList();
        vehicles = in.createStringArrayList();
        starships = in.createStringArrayList();
        planets = in.createStringArrayList();
        characters = in.createStringArrayList();
        releaseDate = in.readString();
        producer = in.readString();
        director = in.readString();
        openingCrawl = in.readString();
        episodeId = in.readInt();
        title = in.readString();
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<String> getStarships() {
        return starships;
    }

    public void setStarships(ArrayList<String> starships) {
        this.starships = starships;
    }

    public ArrayList<String> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<String> planets) {
        this.planets = planets;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeString(edited);
        parcel.writeString(created);
        parcel.writeStringList(species);
        parcel.writeStringList(vehicles);
        parcel.writeStringList(starships);
        parcel.writeStringList(planets);
        parcel.writeStringList(characters);
        parcel.writeString(releaseDate);
        parcel.writeString(producer);
        parcel.writeString(director);
        parcel.writeString(openingCrawl);
        parcel.writeInt(episodeId);
        parcel.writeString(title);
    }
}
