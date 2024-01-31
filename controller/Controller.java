
package controller;

import java.util.List;
import model.Doctor;
import model.DoctorList;
import util.FormatString;
import util.InputUtils;
import static util.InputUtils.sc;


public class Controller {
//    public static DoctorList dtList;
    
    public static void main(String[] args) {
        DoctorList dtList = new DoctorList();
        int choice;
        while (true) {
            choice = Menu.chooseInputOption();
            switch (choice) {
                case 1 -> {
                    addDoctor(dtList);
                }
                case 2 -> {
                    updateDoctor(dtList);
                }
                case 3 -> {
                    deleteDoctor(dtList);
                }
                case 4 -> {
                    searchDoctor(dtList);
                }
                    
                case 5 ->
                    System.exit(0);
            }
        }
    }

    public static Doctor inputDoctor() {
        System.out.println("Enter code: ");
        String code = InputUtils.inputCode();
        System.out.println("Enter name: ");
        String name = InputUtils.inputName();
        name = FormatString.formatName(name);
        System.out.println("Enter Specialization: ");
        String spec = InputUtils.inputSpecialization();
        System.out.println("Enter Availability: ");
        int av = InputUtils.inputInt();
        Doctor dt = new Doctor(code, name, spec, av);
        return dt;

    }

    public static void addDoctor(DoctorList dtList) {
        System.out.println("------ Add Doctor ------");
        if (dtList.addList(inputDoctor())) {
            System.out.println("Added successfully!");
        } else {
            System.out.println("Failed to add. Code is already existed!");
        }
    }

    public static void deleteDoctor(DoctorList dtList) {
        System.out.println("------ Delete Doctor ------");
        System.out.println("Enter code to remove.");
        String codeToRemove = InputUtils.inputCode();
        if (dtList.removeList(codeToRemove)) {
            System.out.println("Remove successfully.");
        } else {
            System.out.println("Failed to remove. Code is not exist!");
        }
    }

    public static void updateDoctor(DoctorList dtList) {
        System.out.println("------ Update Doctor ------");
        System.out.println("Enter code: ");
        String codeToUpdate = InputUtils.inputCode();
        if (dtList.removeList(codeToUpdate)) {
            System.out.println("Enter name: ");
            String name = InputUtils.inputName();
            name = FormatString.formatName(name);
            System.out.println("Enter Specialization: ");
            String spec = InputUtils.inputSpecialization();
            System.out.println("Enter Availability: ");
            int av = InputUtils.inputInt();
            Doctor dt = new Doctor(codeToUpdate, name, spec, av);
            dtList.addList(dt);
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Code is not exist! Failed to update.");
        }
    }
    
    public static void searchDoctor(DoctorList atList){
        System.out.println("----- Search Dcotor -----");
        System.out.println("Enter text: ");
        String input = sc.nextLine().trim();
        try{
            List<Doctor> foundList = atList.searchDoctor(input) ;
            System.out.println("------ Result ------");
            System.out.printf("%-10s|%-20s|%-15s|%10s\n","Code","Name","Speacialization","Availability");
            for(Doctor at: foundList){
                at.toString();
            }
                    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
//    public static void viewAllDoctor(DoctorList dtList){
//        dtList.toString();
    }

