package com.example.demo.model.student;

import java.io.Serializable;

public class UpdateStudent implements Serializable {
    private String name;
    private Integer age;
    private String major;
    private Float cpa;
    private String selfIntroduction;

    public UpdateStudent() {
    }

    public UpdateStudent(String newName, Integer newAge, String newMajor, Float newCpa, String newSelfIntroduction) {
        this.name = newName;
        this.age = newAge;
        this.major = newMajor;
        this.cpa = newCpa;
        this.selfIntroduction = newSelfIntroduction;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer newAge) {
        this.age = newAge;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String newMajor) {
        this.major = newMajor;
    }

    public Float getCpa() {
        return this.cpa;
    }

    public void setCpa(Float newCpa) {
        this.cpa = newCpa;
    }

    public String getSelfIntroduction() {
        return this.selfIntroduction != null ? this.selfIntroduction : "No self-introduction!";
    }

    public void setSelfIntroduction(String newSelfIntroduction) {
        this.selfIntroduction = newSelfIntroduction;
    }
}
