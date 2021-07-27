package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee robert = new Employee();
        Employee sam = new Employee();
        Employee john = new Employee();
        //is for robert data
        robert.setEmployeeName("Robert");
        robert.setYearOfJoin(1994);
        robert.setEmployeeAddress("64C- WallsStreat");

        //is for sam data
        sam.setEmployeeName("Sam");
        sam.setYearOfJoin(2000);
        sam.setEmployeeAddress("68D- WallsStreat");

        //is for John
        john.setEmployeeName("John");
        john.setYearOfJoin(1999);
        john.setEmployeeAddress("26B- WallsStreat");

        //the output
        System.out.println("Name\t" + "\t Year of Joining " + "\t\t Address");
        System.out.println(robert.getEmployeeName() + "\t\t\t" + robert.getYearOfJoin() + "\t\t\t\t\t" + robert.getEmployeeAddress());
        System.out.println(sam.getEmployeeName() + "\t\t\t\t" + sam.getYearOfJoin() + "\t\t\t\t\t" + sam.getEmployeeAddress());
        System.out.println(john.getEmployeeName() + "\t\t\t" + john.getYearOfJoin() + "\t\t\t\t\t" + john.getEmployeeAddress());
    }
}

class Employee {
    String employeeName;
    int yearOfJoin;
    int salary;
    String employeeAddress;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getYearOfJoin() {
        return yearOfJoin;
    }

    public void setYearOfJoin(int yearOfJoin) {
        this.yearOfJoin = yearOfJoin;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}


