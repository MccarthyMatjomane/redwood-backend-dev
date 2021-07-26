package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int indexNum; //will use it to know which users was called to help in displaying the right balance


    static int menu() {
        int menuNum; //used to select which function to execute on the menu
        System.out.println("Enter 1 to check Balance: ");
        System.out.println("Enter 2 to do Deposit: ");
        System.out.println("Enter 3 to Withdraw Money : ");
        System.out.println("Enter 4 to Transfer Money: ");
        System.out.println("Enter 5 to LogOut\n");
        System.out.print("Enter Number: ");
        return input.nextInt();
    }

    static void balance(String[][] accountInfo) {
        System.out.println("the Balance is: " + accountInfo[indexNum][2]);
    }
    static void deposit(String[][] accountInfo) {
        System.out.print("Enter Deposit Amount: ");
        int depositAmount = input.nextInt();
        String numStr = accountInfo[indexNum][2].trim();
        int balanceNum = Integer.parseInt(numStr);
        int updatedBalance = depositAmount + balanceNum;
        accountInfo[indexNum][2] = String.valueOf(updatedBalance);
        System.out.println("Successful Deposit of: " + depositAmount);
    }
    static void withdraw(String[][] accountInfo){
        System.out.print("Enter Withdrawal Amount: ");
        int withdrawalAmount = input.nextInt();
            String numStr = accountInfo[indexNum][2].trim();
            System.out.println(numStr);
            int balanceNum = Integer.parseInt(numStr);
            int updatedBalance = balanceNum - withdrawalAmount ;
            accountInfo[indexNum][2] = String.valueOf(updatedBalance);
        System.out.println("Successful withdrawal of: " + withdrawalAmount);
    }
    static void transfer(String[][] accountInfo) {
        System.out.print("Enter Username: ");
        String clientName = input.next().trim().toLowerCase();
        System.out.print("Enter Amount: ");
        int transferAmount = input.nextInt();
        for (int i = 0; i < accountInfo.length; i++) {
            if (clientName.equalsIgnoreCase(accountInfo[i][0].trim())) {
                //this code is to minus the transfer amount from the sender balance
                String numStr = accountInfo[indexNum][2].trim();
                int balanceNum = Integer.parseInt(numStr);
                int updatedBalance = balanceNum - transferAmount ;
                accountInfo[indexNum][2] = String.valueOf(updatedBalance);
                //this code is to transfer money
                String numStr2 = accountInfo[i][2].trim();
                int balanceNum2 = Integer.parseInt(numStr2);
                int updatedBalance2 = balanceNum2 + transferAmount ;
                accountInfo[i][2] = String.valueOf(updatedBalance2);
                //**************************************
                System.out.println("Tranferred succeessfully");
            }
        }
    }

    static boolean logIn(String[][] accountInfo) {
        System.out.println("********Log In************");
        System.out.println("enter username to log in");
        String username = input.nextLine();
        System.out.println("enter password to log in");
        String password = input.nextLine();
        for (int j = 0; j < accountInfo.length; j++) {
            if (username.equalsIgnoreCase(accountInfo[j][0].trim())) {
                if (password.equals(accountInfo[j][1].trim())) {
                    System.out.println("LogIn Successful");
                    indexNum = j;
                    return true;
                }
            }
        }
        System.out.println("please enter correct username and password");
        return false;
    }

    public static void main(String[] args) throws IOException {
        //------------------------------------------------
        BufferedReader csvReader = new BufferedReader(new FileReader("accountInfo.csv"));
        String row;
        String[][] accountInfo = new String[4][4];
        int i = 0;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            accountInfo[i] = data;
            i++;
            }
        boolean loggedIn = logIn(accountInfo);
        while (!loggedIn) {
            loggedIn = logIn(accountInfo);

        }

        while(true){
            int number = menu();
            if (number==1){
                balance(accountInfo);
                continue;
            }
            else if (number==2){
                deposit(accountInfo);
                continue;
            }
            else if (number==3){
                withdraw(accountInfo);
                continue;
            }
            else if (number==4){
                transfer(accountInfo);
                continue;
            }
            else{
                System.out.println("Logged out");
                break;
            }


        }

        }

    }




