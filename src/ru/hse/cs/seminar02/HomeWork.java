package ru.hse.cs.seminar02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class HomeWork {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("**Перевод миль в км**");
        System.out.print("Введите мили:");
        System.out.println(Mile2Km(ReadNumber(0)));

        System.out.println("**Перевод км в мили**");
        System.out.print("Введите км:");
        System.out.println(Km2Mile(ReadNumber(0)));

        System.out.println("**Перевод цельсия в фаренгейт**");
        System.out.print("Введите цельсия:");
        System.out.println(Celsium2Farenheit(ReadNumber(-Double.MAX_VALUE)));

        System.out.println("**Перевод фаренгейт в цельсия**");
        System.out.print("Введите фаренгейт:");
        System.out.println(Farenheit2Celsium(ReadNumber(-Double.MAX_VALUE)));
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER: //Нажата клавиша Enter
                break;

            default:
        }
    }

    private static double ReadNumber(double leftBound) {
        double number;
        while (true) {
            try {
                if (!sc.hasNextDouble()) {
                    sc.next();
                    throw new IllegalArgumentException("Вы ввели не число! Попробуйте еще раз");
                }
                number = sc.nextDouble();
                if (number < leftBound) {
                    throw new IllegalArgumentException("Перевод для данного числа невозможен! Попробуйте еще раз");
                }
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return number;
    }

    private static double Mile2Km(double number) {
        return number * 1.6093;
    }

    private static double Km2Mile(double number) {
        return number / 1.6093;
    }

    private static double Celsium2Farenheit(double number) {
        return (9 / 5.0) * number + 32;
    }

    private static double Farenheit2Celsium(double number) {
        return (5 / 9.0) * (number - 32);
    }
}

