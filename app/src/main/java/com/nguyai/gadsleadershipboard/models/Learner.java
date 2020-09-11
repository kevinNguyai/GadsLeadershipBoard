package com.nguyai.gadsleadershipboard;

public class Learner {
    private String learnerName;
    private int learningHours;
    private String country;

    public Learner(String learnerName, int learningHours, String country) {
        this.learnerName = learnerName;
        this.learningHours = learningHours;
        this.country = country;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public int getLearningHours() {
        return learningHours;
    }

    public void setLearningHours(int learningHours) {
        this.learningHours = learningHours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
