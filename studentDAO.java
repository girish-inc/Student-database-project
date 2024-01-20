package com.itvedant.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {
  static Connection con = DBConnect.getConnection();

  public List<students> getRecords() {
    List<students> student = new ArrayList<>();
    String query = "select * from students";
    try {
      Statement stat = con.createStatement();
      ResultSet rs = stat.executeQuery(query);
      while (rs.next()) {
        students s = new students();
        s.setSt_id(rs.getInt("st_id"));
        s.setSt_name(rs.getString("st_name"));
        s.setCity(rs.getString("city"));
        s.setMarks(rs.getInt("marks"));
        s.setGender(rs.getString("gender"));
        s.setMobile_no(rs.getString("Mobile_no"));
        student.add(s);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return student;
  }

  public boolean insertRecord(String name, String city, int marks, String gender, String mobile_no) {
    String query = "insert into students(st_name,city,marks,gender,Mobile_no) values(?,?,?,?,?)";
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, name);
      ps.setString(2, city);
      ps.setInt(3, marks);
      ps.setString(4, gender);
      ps.setString(5, mobile_no);
      int i = ps.executeUpdate();
      if (i > 0) {
        return true;
      }
    } catch (Exception e) {
      System.out.println();
    }
    return false;
  }

  public boolean deleteRecord(int id) {
    String query = "delete from students where st_id = ?";
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, id);
      int i = ps.executeUpdate();
      if (i > 0) {
        return true;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  public students searchRecord(String name) {
    students s = null;
    String query = "select * from students where st_name = ?";
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) { s = new students();
        s.setSt_id(rs.getInt("st_id"));
        s.setSt_name(rs.getString("st_name"));
        s.setCity(rs.getString("city"));
        s.setMarks(rs.getInt("marks"));
        s.setGender(rs.getString("gender"));
        s.setMobile_no(rs.getString("Mobile_no"));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return s;
  }
  public boolean updateRecord(students s){
    String query = "update students set st_name=?, city=?, marks=?, Mobile_no = ?, gender = ? where st_id=?";
    try{
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, s.getSt_name());
      ps.setString(2, s.getCity());
      ps.setInt(3, s.getMarks());
      ps.setString(4, s.getMobile_no());
      ps.setString(5, s.getGender());
      ps.setInt(6, s.getSt_id());
      int i = ps.executeUpdate();
      if (i >0) {
        return true;
      }
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
    return false;
  }
}
