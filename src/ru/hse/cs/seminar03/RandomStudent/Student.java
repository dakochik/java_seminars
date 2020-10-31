package ru.hse.cs.seminar03.RandomStudent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Student {
    String name;
    String surname;
    List<Integer> mark = new ArrayList<Integer>();

    public Student(String surname, String name) {
        this.name = name;
        this.surname = surname;
    }


    @Override
    public String toString() {
        int resultPoint = 0;
        // Получение количества оценок ученика
        BigDecimal secondPart = BigDecimal.valueOf(mark.stream().count());

        if (secondPart.intValue() != 0) {

            // Получение суммы всех оценок ученика
            BigDecimal firstPart = BigDecimal.valueOf(mark.stream().mapToInt(Integer::intValue).sum());

            // Округление результата
            resultPoint = (int) Math.round((firstPart.divide(secondPart)).doubleValue());
        }
        return surname + " " + name + " - Оценка: " + resultPoint;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            Student student = (Student) obj;
            return student.name.equals(name) && student.surname.equals(surname);
        }
        return false;
    }
}
