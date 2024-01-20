package com.itvedant.student;

public class students {
   int st_id;
   String st_name;
   String city;
   String gender;
   String mobile_no;
   int marks;

  public int getSt_id() {
    return st_id;
  }

  public String getSt_name() {
    return st_name;
  }

  public String getCity() {
    return city;
  }

  public String getGender() {
    return gender;
  }

  public String getMobile_no() {
    return mobile_no;
  }

  public int getMarks() {
    return marks;
  }

  public void setSt_id(int st_id) {
    this.st_id = st_id;
  }

  public void setSt_name(String st_name) {
    this.st_name = st_name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setMobile_no(String mobile_no) {
    this.mobile_no = mobile_no;
  }

  public void setMarks(int marks) {
    this.marks = marks;
  }

  @Override
  public String toString() {
    return "students{" +
            "st_id=" + st_id +
            ", st_name='" + st_name + '\'' +
            ", city='" + city + '\'' +
            ", gender='" + gender + '\'' +
            ", mobile_no=" + mobile_no +
            ", marks=" + marks +
            '}';
  }
}