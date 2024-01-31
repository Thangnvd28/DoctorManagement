
package controller;

import util.InputUtils;


public class Menu {
    public static int chooseInputOption(){
        System.out.println("========= Doctor Management =========");
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        int option = InputUtils.inputOption(1, 5);
        return option;
    }
}
