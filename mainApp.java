package com.itvedant.student;

import java.util.List;
import java.util.Scanner;

public class mainApp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true){
      System.out.println("Choose the operation to be performed");
      System.out.println("1) Display all the record");
      System.out.println("2) Insert Records");
      System.out.println("3) Delete Records");
      System.out.println("4) Search Records");
      System.out.println("5) Update Records");
      System.out.println("6) Exit from the menu");

      System.out.println("Enter your choice!");
      int choice = sc.nextInt();
      if (choice == 6) {
        break;
      }
      else {
        studentDAO sd = new studentDAO();
        String name = "";
        String city = "";
        int marks  = 0;
        String mobile_no ="";
        String gender = "M";
        switch (choice){
          case 1:
            List<students> studs = sd.getRecords();
            studs.forEach(System.out::println);
            break;
          case 2:
            System.out.println("Enter name: ");
            name = sc.next();
            System.out.println("Enter city: ");
            city = sc.next();
            System.out.println("Enter marks: ");
            marks = sc.nextInt();
            System.out.println("Enter gender: ");
            gender = sc.next();
            System.out.println("Enter Mobile_no: ");
            mobile_no = sc.next();
            boolean b = sd.insertRecord(name, city,marks,gender,mobile_no);
            if (b) {
              System.out.println("Records inserted");
            }
            break;
          case 3:
            studs = sd.getRecords();
            studs.forEach(System.out::println);
            System.out.println("Enter the ID the student whose record is you want to deleted");
            int id = sc.nextInt();
             b = sd.deleteRecord(id);
            if (b) {
              System.out.println("Record is deleted for id = "+id);
            }
            break;
          case 4:
            System.out.println("Enter the name of the student you want to search!");
            name = sc.next();
            students st = sd.searchRecord(name);
            if (st == null) {
              System.out.println("No records found!");
            }else{
              System.out.println(st);
            }
            break;
          case 5:
            studs = sd.getRecords();
            studs.forEach(System.out::println);
            System.out.println("Enter name of the student you want to update!");
            name = sc.next();
            st = sd.searchRecord(name);
            if (st == null) {
                  System.out.println("No records found!");
            }else {
                  System.out.println("Update");
                  System.out.println("What do you want to update?");
                  System.out.println("a)Name\nb)City\nc)Marks\nd)Mobile no.\ne)Gender\nEnter your choice!");
                  char updateChoice = sc.next().charAt(0);
              switch (updateChoice) {
                case 'a' -> {
                  System.out.println("Enter new name");
                  name = sc.next();
                  st.setSt_name(name);
                }
                case 'b' -> {
                  System.out.println("Enter new city");
                  city = sc.next();
                  st.setCity(city);
                }
                case 'c' -> {
                  System.out.println("Enter new marks");
                  marks = sc.nextInt();
                  st.setMarks(marks);
                }
                case 'd' ->{
                  System.out.println("Enter new mobile no.");
                  mobile_no = sc.next();
                  st.setMobile_no(mobile_no);
                }
                case 'e' ->{
                  System.out.println("Enter new gender");
                  gender = sc.next();
                  st.setGender(gender);
                }
                default -> System.out.println("Enter the correct choice next time!");
              }
              b = sd.updateRecord(st);
              if (b) {
                System.out.println("Records are updated!");
              }
            }
            break;
          default:
            System.out.println("Please Enter correct number");
        }
      }
    }
    DBConnect.closeConnection();
  }
}
