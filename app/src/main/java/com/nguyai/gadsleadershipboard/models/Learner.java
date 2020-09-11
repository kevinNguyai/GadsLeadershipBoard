package com.nguyai.gadsleadershipboard.models;

import java.net.URI;

public class Learner {
    private String name;
    private int hours;
    private String country;
    private URI badgeUrl;

    public Learner(String name, int hours, String country, URI badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public URI getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(URI badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
