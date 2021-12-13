package com.example.demo.model.student;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity()
@Table(name = "Student", schema = "spring_boot_demo")
@EntityListeners(AuditingEntityListener.class)
public class Student implements Serializable {
    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    private Integer age;

    @NotBlank
    private String major;

    @Column(nullable = false)
    private Float cpa;

    @Column(nullable = true, length = 255, name = "self_introduction")
    private String selfIntroduction;

    @Column(nullable = false, updatable = false, name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    // methods
    public Student() {
    }

    public Student(String newName, Integer newAge, String newMajor, Float newCpa, String newSelfIntroduction) {
        this.name = newName;
        this.age = newAge;
        this.major = newMajor;
        this.cpa = newCpa;
        this.selfIntroduction = newSelfIntroduction;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName != null ? newName : this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer newAge) {
        this.age = newAge != null ? newAge : this.age;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String newMajor) {
        this.major = newMajor != null ? newMajor : this.major;
    }

    public Float getCpa() {
        return this.cpa;
    }

    public void setCpa(Float newCpa) {
        this.cpa = newCpa != null ? newCpa : this.cpa;
    }

    public String getSelfIntroduction() {
        return this.selfIntroduction != null ? this.selfIntroduction : "No self-introduction!";
    }

    public void setSelfIntroduction(String newSelfIntroduction) {
        this.selfIntroduction = newSelfIntroduction != null ? newSelfIntroduction : this.selfIntroduction;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }
}

