package com.nguyai.gadsleadershipboard.models;

import java.net.URI;

public class SkillsIQLeader {
    private String name;
    private int score;
    private String country;
    private URI badgeUrl;

    public SkillsIQLeader(String name, int score, String country, URI badgeUrl) {
        this.name = name;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
