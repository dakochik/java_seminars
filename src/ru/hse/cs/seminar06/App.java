package ru.hse.cs.seminar06;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.put(10);
        System.out.println(list.contains(10));

        list.removeAt(0);
        System.out.println(list.contains(10));


        list.put(10);
        list.clear();
        System.out.println(list.contains(10));

        list.put(10);
        list.put(100);
        System.out.println(list.get(1));
    }
}
