package com.company;

public class Main extends Employee{

    public static void main(String[] args) {
	// write your code here

        Main employeeInfo = new Main();
        System.out.println("Name\t" + "Year of joining\t" + "\tAddress");
        for (int i = 0; i < employeeInfo.employeeAddress.length; i++) {
            System.out.println(employeeInfo.employeeNames[i] + "\t" + employeeInfo.yearJoined[i] + "\t\t\t\t" + employeeInfo.employeeAddress[i]);
        }
    }
}
