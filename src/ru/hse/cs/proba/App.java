package ru.hse.cs.proba;

public class App {
    public static void main(String[] args) {

        Long a = 1L;
        Long b = 1L;
        Long c = 1L;
        Long d = 1L;

        System.out.println("First" + a);
        System.out.println("Second" + b);
        System.out.println("Third" + c);


        for (int i = 4; i <= 82; i++) {

                d = a+b;
                a=b;
                b=c;
                c=d;


            System.out.println(i + "  " + d);


        }


    }
}
