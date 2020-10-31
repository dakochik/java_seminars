package ru.hse.cs.seminar01;
//Напишите программу, которая выводит на экран числа от 1 до 100. При этом вместо чисел, кратных трем,
// программа должна выводить слово "Fizz", а вместо чисел, кратных пяти — слово "Buzz".
// Если число кратно и 3, и 5, то программа должна выводить слово "FizzBuzz".



public class Application {
    public static void main(String[] args) {
        FizzBuzz();
    }


    static void FizzBuzz() {

        for (int i = 1; i <= 100; i++) {

            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
                continue;

            } else {

                if (i % 3 == 0) {

                    System.out.println("Fizz");
                    continue;
                }

                if (i % 5 == 0) {
                    System.out.println("Buzz");
                    continue;
                }
            }
            System.out.println(i);
        }
    }
}