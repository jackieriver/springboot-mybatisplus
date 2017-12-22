package com.river.pojo;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.List;

/**
 * Created by Administrator on 2017/10/9.
 */
@TableName("JY_USERS")
public class JYUsers {

    private Long id;

    private Long userId;

    private String membership;

    private String description;

    private String education;

    private Double height;

    //0--没有,1--有
    private int haveCar;

    private String monthSalary;

    private String house;

    private Double weight;
    //星座
    private String constellation;

    //民族
    private String national;

    private String animalSign;

    private String bloodSign;

    private String interview;

    private String chooseAge;

    private String chooseheight;

    private String chooseEducation;

    private String liveAdress;

    private List<String> photoUrls;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public int getHaveCar() {
        return haveCar;
    }

    public void setHaveCar(int haveCar) {
        this.haveCar = haveCar;
    }

    public String getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(String monthSalary) {
        this.monthSalary = monthSalary;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getAnimalSign() {
        return animalSign;
    }

    public void setAnimalSign(String animalSign) {
        this.animalSign = animalSign;
    }

    public String getBloodSign() {
        return bloodSign;
    }

    public void setBloodSign(String bloodSign) {
        this.bloodSign = bloodSign;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public String getChooseAge() {
        return chooseAge;
    }

    public void setChooseAge(String chooseAge) {
        this.chooseAge = chooseAge;
    }

    public String getChooseheight() {
        return chooseheight;
    }

    public void setChooseheight(String chooseheight) {
        this.chooseheight = chooseheight;
    }

    public String getChooseEducation() {
        return chooseEducation;
    }

    public void setChooseEducation(String chooseEducation) {
        this.chooseEducation = chooseEducation;
    }

    public String getLiveAdress() {
        return liveAdress;
    }

    public void setLiveAdress(String liveAdress) {
        this.liveAdress = liveAdress;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }
}
