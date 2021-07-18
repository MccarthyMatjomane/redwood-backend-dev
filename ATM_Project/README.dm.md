ATM PROJECT CODE
package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    String[] usernames = {"mccarthy","priyanshi","charlotte"};
    int[] passwords = {1234,6789,5432};
    int[] balances = {1500,800,3500};
    Scanner input = new Scanner(System.in);
    int indexnum; //will use it to know which users was called to help in displaying the right balance
    public void logIn(String usName,int psWord ){
        while(true){
            String userFound = "";
            for (int i = 0; i < 3; i++) {
                    if (usernames[i].equals(usName) && passwords[i] == psWord) {
                        userFound = "login Successful";
                        System.out.println(userFound);
                        indexnum = i;
                        i = 0;
                        break;
                    }
            }
            if (!userFound.equals("login Successful") ){
                System.out.println("please Enter correct username and Password");
                System.out.print("enter username: ");
                usName = input.next().trim().toLowerCase();
                System.out.print("enter password: ");
                psWord = input.nextInt();
                continue;
            }
            break;
        }
        }
        public void menu() {
            int menuNum; //used to select which function to execute on the menu
            while  (true){
                System.out.println("Enter 1 to check Balance: ");
                System.out.println("Enter 2 to do Deposit: ");
                System.out.println("Enter 3 to Withdraw Money : ");
                System.out.println("Enter 4 to Transfer Money: ");
                System.out.println("Enter 5 to LogOut\n");
                System.out.print("Enter Number: ");
                menuNum = input.nextInt();
                if (menuNum == 1) {
                    System.out.println("The balance is: " + balances[indexnum]);
                    continue;
                }
                else if (menuNum == 2) {
                    System.out.print("Enter Deposit Amount: ");
                    int depositAmount = input.nextInt();
                    balances[indexnum] = balances[indexnum] + depositAmount;
                    continue;
                } else if (menuNum == 3) {
                    System.out.print("Enter Withdrawal Amount: ");
                    int withdrawalAmount = input.nextInt();
                    balances[indexnum] = balances[indexnum] - withdrawalAmount;
                    continue;
                } else if (menuNum == 4) {
                    System.out.print("Enter Username: ");
                    String clientName = input.next().trim().toLowerCase();
                    System.out.print("Enter Amount: ");
                    int transferAmount = input.nextInt();
                    for (int i = 0; i < 3; i++) {
                        if (usernames[i].equals(clientName)) {
                            balances[i] = balances[i] + transferAmount;
                            balances[indexnum] = balances[indexnum] - transferAmount;
                            System.out.println("Tranferred succeessfully");
                        }
                    }
                    continue;
                } else
                    break;

            }



        }

    public static void main(String[] args) {
        String uname;
        int psword;
        Scanner input = new Scanner(System.in);
        System.out.print("please enter username: ");
        uname = input.next().trim().toLowerCase();
        System.out.print("please enter password: ");
        psword = input.nextInt();
        Main clasObj = new Main();
        clasObj.logIn(uname,psword);
        clasObj.menu();
    }
    }
