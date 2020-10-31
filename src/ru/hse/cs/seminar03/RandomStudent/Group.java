package ru.hse.cs.seminar03.RandomStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Group {
    Random rnd = new Random();
    List<Student> group = new ArrayList<Student>();

    public Group() {
        group.add(new Student("Ассатиани", "Тимур"));
        group.add(new Student("Галанов", "Александр"));
        group.add(new Student("Точилина", "Полина"));
        group.add(new Student("Ткаченко", "Никита"));
        group.add(new Student("Кочарян", "Тигран"));
        group.add(new Student("Кузнецов", "Михаил"));
        group.add(new Student("Волкова", "София"));
        group.add(new Student("Волохов", "Никита"));
        group.add(new Student("Сальникова", "Алиса"));
        group.add(new Student("Федченко", "Всеволод"));
        group.add(new Student("Кочик", "Дмитрий"));
        group.add(new Student("Поволоцкий", "Виктор"));
        group.add(new Student("Вахитова", "Диана"));
        group.add(new Student("Щербаков", "Дмитрий"));
        group.add(new Student("Поляков", "Лев"));
        group.add(new Student("Мурзабеков", "Султан"));
        group.add(new Student("Кан", "Алексей"));
        group.add(new Student("Куприхин", "Дмитрий"));
        group.add(new Student("Борисов", "Константин"));
        group.add(new Student("Крылов", "Павел"));
        group.add(new Student("Джураев", "Рашид"));
        group.add(new Student("Шарипов", "Сардор"));
        group.add(new Student("Ризоева", "Амина"));
        group.add(new Student("Сатыбалды", "Касымжомарт"));
        group.add(new Student("Голикова", "Екатерина"));
        group.add(new Student("Максимов", "Михаил"));
        group.add(new Student("Мостачев", "Андрей"));
        group.add(new Student("Ермилов", "Артемий"));
        group.add(new Student("Скрыпников", "Егор"));
        group.add(new Student("Агроскин", "Александр"));
    }


    public Student randomStudent() {
        return group.get(rnd.nextInt(group.size()));
    }

    public void add(Student student) {
        group.add(student);
    }

    public void remove(Student student) {
        if (group.contains(student)) {
            group.remove(student);
        } else {
            System.out.println("Такого Студента в группе БПИ199 нет!");
        }
    }

    public Student getStudent(String surname) {
        Student student = group.stream()
                .filter(x -> surname.equals(x.surname))
                .findFirst().orElse(null);
        return student;
    }

    @Override
    public String toString() {
        return "БПИ199:\n" + group.stream()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));
    }
}
