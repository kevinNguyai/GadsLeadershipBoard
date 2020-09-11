package com.nguyai.gadsleadershipboard;

public class SkillsIQLeader {
    private String leaderName;
    private int score;
    private String country;

    public SkillsIQLeader(String leaderName, int score, String country) {
        this.leaderName = leaderName;
        this.score = score;
        this.country = country;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
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
