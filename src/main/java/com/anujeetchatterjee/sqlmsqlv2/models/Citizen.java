package com.anujeetchatterjee.sqlmsqlv2.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CITIZEN_TABLE")
public class Citizen {
    @GeneratedValue
    @NotNull
    private int id;

    @Id
    @NotNull
    private int aadhaarNumber;

    private String name;
    private int age;
    private char gender;
    private int phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String district;
    private String state;
    private String latitude;
    private String longitude;
    private String nationality;
    private Boolean previouslyContractedWithCOVID19;
    // if True
    private Date dateWhenTestedPositive;
    private Date dateWhenTestedNegative;
    private String hospitalName;

    private Boolean currentlySufferingFromCOVID19;
    private String disability;

    public Citizen(
            int aadhaarNumber,
            String name,
            int age,
            char gender,
            int phoneNumber,
            String addressLine1,
            String addressLine2,
            String district,
            String state,
            String latitude,
            String longitude,
            String nationality,
            Boolean previouslyContractedWithCOVID19,
            Date dateWhenTestedPositive,
            Date dateWhenTestedNegative,
            String hospitalName,
            Boolean currentlySufferingFromCOVID19,
            String disability
    ) {
        this.aadhaarNumber = aadhaarNumber;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.district = district;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nationality = nationality;
        this.previouslyContractedWithCOVID19 = previouslyContractedWithCOVID19;
        this.dateWhenTestedPositive = dateWhenTestedPositive;
        this.dateWhenTestedNegative = dateWhenTestedNegative;
        this.hospitalName = hospitalName;
        this.currentlySufferingFromCOVID19 = currentlySufferingFromCOVID19;
        this.disability = disability;
    }

    public int getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(int aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getPreviouslyContractedWithCOVID19() {
        return previouslyContractedWithCOVID19;
    }

    public void setPreviouslyContractedWithCOVID19(Boolean previouslyContractedWithCOVID19) {
        this.previouslyContractedWithCOVID19 = previouslyContractedWithCOVID19;
    }

    public Date getDateWhenTestedPositive() {
        return dateWhenTestedPositive;
    }

    public void setDateWhenTestedPositive(Date dateWhenTestedPositive) {
        this.dateWhenTestedPositive = dateWhenTestedPositive;
    }

    public Date getDateWhenTestedNegative() {
        return dateWhenTestedNegative;
    }

    public void setDateWhenTestedNegative(Date dateWhenTestedNegative) {
        this.dateWhenTestedNegative = dateWhenTestedNegative;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Boolean getCurrentlySufferingFromCOVID19() {
        return currentlySufferingFromCOVID19;
    }

    public void setCurrentlySufferingFromCOVID19(Boolean currentlySufferingFromCOVID19) {
        this.currentlySufferingFromCOVID19 = currentlySufferingFromCOVID19;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", aadhaarNumber=" + aadhaarNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", nationality='" + nationality + '\'' +
                ", previouslyContractedWithCOVID19=" + previouslyContractedWithCOVID19 +
                ", dateWhenTestedPositive=" + dateWhenTestedPositive +
                ", dateWhenTestedNegative=" + dateWhenTestedNegative +
                ", hospitalName='" + hospitalName + '\'' +
                ", currentlySufferingFromCOVID19=" + currentlySufferingFromCOVID19 +
                ", Disability='" + disability + '\'' +
                '}';
    }
}
