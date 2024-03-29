
package util;

import java.util.Scanner;


public class InputUtils {

    public static Scanner sc = new Scanner(System.in);

    public static String inputCode() {
        String code;
        while (true) {
            try {
                code = sc.nextLine().trim();
                if (!code.matches("[a-zA-Z0-9]+")) {
                    throw new IllegalArgumentException("Invalid code. Please enter a valid code.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return code;
    }

    public static String inputName() {
        String name;
        while (true) {
            try {
                name = sc.nextLine();

                if (!name.matches("[a-zA-Z0-9 -.]+")) {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return name;
    }

    public static int inputInt() {
        int rs;
        while (true) {
            try {
                rs = Integer.parseInt(sc.nextLine());
                if (rs <= 0) {
                    throw new ArithmeticException("Not valid. Enter a positive number.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Pls input a valid integer number.");
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return rs;
    }

    public static int inputOption(int min, int max) {
        int rs;
        while (true) {
            try {
                rs = Integer.parseInt(sc.nextLine());
                if (rs < min || rs > max) {
                    throw new ArithmeticException("Not valid. Enter a valid number from " + min + " to " + max + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Pls input a valid integer number.");
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return rs;
    }

    public static String inputSpecialization() {
        String str;
        boolean loop;
        do {
            loop = false;
            str = sc.nextLine();
            if (str.length() > 40) {
                loop = true;

            }
        } while (loop);
        return str;
    }
}
