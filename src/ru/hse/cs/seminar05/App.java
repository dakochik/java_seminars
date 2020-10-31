package ru.hse.cs.seminar05;

import org.w3c.dom.ls.LSOutput;

public class App {
    public static void main(String[] args) {

        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);


        System.out.println(myList.contains(10));
        myList.removeAt(5);
        System.out.println(myList.contains(10));



        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        try {
            myList.removeAt(100);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(myList.getSize());

    }
}
