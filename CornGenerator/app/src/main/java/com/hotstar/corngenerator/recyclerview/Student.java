package com.hotstar.corngenerator.recyclerview;

public class Student {
    private String name;
    private String age;
    private String mobile;
    private String address;
    private String bloodGroup;

    public Student(String name, String age, String mobile, String address, String bloodGroup) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
