package ru.hse.cs.seminar03.homeWorkLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    static final String info = "\n" +
            "1. Посмотреть библиотеку\n" +
            "2. Посмотреть мои книги\n" +
            "3. Взять книгу\n" +
            "4. Вернуть книгу\n" +
            "5. Проверить есть ли книга\n" +
            "6. Выйти из программы\n" +
            "Вы ввели: ";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        Library library = new Library();
        List<Book> myBooks = new ArrayList<Book>();


        while (true) {
            System.out.print(info);
            switch (sc.nextLine()) {
                case "1":
                    System.out.println(library);
                    break;
                case "2":
                    System.out.println("Моя коллекция:\n" + myBooks.stream()
                            .map(Book::toString)
                            .collect(Collectors.joining("\n")));
                    break;
                case "3":
                    takeBook(library, myBooks);
                    break;
                case "4":
                    returnBook(library, myBooks);
                    break;
                case "5":
                    containsBook(library);
                    break;
                case "6":
                    System.out.println("Удачного дня!");
                    return;
                default:
                    System.out.println("Вы ввели краказябру, попробуйте еще раз");
                    break;
            }

        }
    }

    private static void containsBook(Library library) {
        System.out.print("Введите название книги: ");
        String name = sc.nextLine();
        if (library.contains(name)) {
            System.out.println("Книга \"" + name + "\" присутствует в библиотеке");
        } else {
            System.out.println("В библиотеке нет книги \"" + name + "\"");
        }
    }

    private static void returnBook(Library library, List<Book> myBook) {
        if (!myBook.isEmpty()) {

            System.out.println("У вас есть следующие книги:\n" + myBook.stream()
                    .map(Book::toString)
                    .collect(Collectors.joining("\n")));

            System.out.print("Введите название книги,которую хотите вернуть:");

            Book book = new Book(sc.nextLine());
            if (!myBook.contains(book)) {
                System.out.println("У вас нет книги: " + book);
            } else {
                library.returnBook(book);
                myBook.remove(book);
            }
        } else {
            System.out.println("У вас нет книг!");
        }
    }

    private static void takeBook(Library library, List<Book> myBook) {
        System.out.print("Введите название книги: ");
        try {

            Book book = library.TakeBook(sc.nextLine());
            myBook.add(book);
            System.out.println("Вы взяли книгу: " + book);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
