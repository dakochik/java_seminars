package ru.hse.cs.seminar03.homeWorkLibrary;

public class Book {
    String name;


    public Book(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Book other = (Book) obj;
            return name.equals(other.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
