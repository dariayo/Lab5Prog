package client;

import data.Color;
import data.Country;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The class is responsible for what the user enters
 */
public class ReadManager {
    public static String readName(Scanner sc) {
        System.out.println("Введите имя персонажа ");
        String name = sc.nextLine().trim();
        while (true) {
            if (name.equals("")) {
                System.out.println("Имя не может быть пустой строкой, введите имя");
                name = sc.nextLine().trim();
            } else {
                return name;
            }
        }
    }
    
    public static Long readCoordinatesX(Scanner sc) {
        System.out.println("Введите координату X");
        while (true) {
            try {
                String X_string = sc.nextLine().trim();
                long X = Long.parseLong(X_string);
                if (!X_string.equals("")) {
                    return X;
                } else {
                    System.out.println("Вы должны ввести число, а не пустую строку");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }
        }
    }

    public static Integer readCoordinatesY(Scanner sc) {
        System.out.println("Введите координату Y");
        while (true) {
            try {
                String Y_string = sc.nextLine().trim();
                int Y = Integer.parseInt(Y_string);
                if (Y_string.equals("")) {
                    return Y;
                } else {
                    System.out.println("Вы должны ввести число, а не пустую строку");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }
        }
    }
    
    public static Integer readHeight(Scanner sc) {
        System.out.println("Введите рост персонажа");
        while (true) {
            String height_string = sc.nextLine().trim();
            try {
                int height = Integer.parseInt(height_string);
                if (height > 0) {
                    return height;
                } else {
                    System.out.println("Рост должен быть больше 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }
        }
    }
}
