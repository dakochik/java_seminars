package ru.hse.cs.seminar03.homeWorkLibrary;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    List<Book> library = new ArrayList<Book>();

    public Library() {
        library.add(new Book("Мастер и Маргарита"));
        library.add(new Book("Мёртвые души"));
        library.add(new Book("Собачье сердце"));
        library.add(new Book("Двенадцать стульев"));
        library.add(new Book("Преступление и наказание"));
        library.add(new Book("Война и мир"));
    }

    public void returnBook(Book book) {
        library.add(book);
    }

    public Book TakeBook(String name) {

        if (!contains(name)) {
            throw new IllegalArgumentException("Такой книги нет!");
        }

        Book book = new Book(name);
        library.remove(book);
        return book;
    }

    public boolean contains(String name) {
        Book book = new Book(name);
        return library.contains(book);
    }

    @Override
    public String toString() {
        return "Коллекция библиотеки:\n" + library.stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n"));
    }
}
