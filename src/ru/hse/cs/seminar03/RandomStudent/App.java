package ru.hse.cs.seminar03.RandomStudent;

import java.util.Scanner;

public class App {

    static final String info = "\n" +
            "1. Увидеть состав группы БПИ199\n" +
            "2. Тыкнуть наугад в студента\n" +
            "3. Выбрать отвечающего по фамилии\n" +
            "4. Добавить\\Исключить студента\n" +
            "5. Выйти из программы\n" +
            "Вы ввели: ";

    static final String addInfo = "\n" +
            "1. Добавить студента\n" +
            "2. Отчислить студента\n" +
            "Вы ввели: ";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Group bpi199 = new Group();
        while (true) {
            System.out.print(info);
            switch (sc.nextLine()) {

                case "1":
                    System.out.println(bpi199);
                    break;

                case "2":
                    randomStudent(bpi199);
                    break;

                case "3":
                    takeStudent(bpi199);
                    break;

                case "4":
                    addOrRemove(bpi199);
                    break;

                case "5":
                    System.out.println("Удачного дня!");
                    return;

                default:
                    System.out.println("Вы ввели краказябру, попробуйте еще раз");
                    break;
            }

        }
    }

    private static void addOrRemove(Group bpi199) {
        System.out.print(addInfo);
        switch (sc.nextLine()) {

            case "1":
                Student student = inputStudent();
                bpi199.add(student);
                break;

            case "2":
                student = inputStudent();
                bpi199.remove(student);
                break;

            default:
                System.out.println("Вы ввели краказябру");
                break;
        }
    }

    private static Student inputStudent() {

        System.out.print("Введите фамилию, имя студента (в И.П.): ");
        while (true) {
            try {
                String[] arr = sc.nextLine().split(" ");
                return new Student(arr[0], arr[1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Вы не ввели фамалию имя. Попробуйте еще раз!");
            }
        }
    }


    private static void takeStudent(Group bpi199) {
        System.out.print("Введите фамилию студента (в И.П): ");
        String surname = sc.nextLine();
        Student student = bpi199.getStudent(surname);
        if (student == null) {
            System.out.println("Студента с такой фамилией нет!");
            return;
        }
        giveMark(student);
    }

    private static void randomStudent(Group bpi199) {
        Student student = bpi199.randomStudent();
        giveMark(student);
    }

    private static void giveMark(Student student) {
        System.out.print(student.surname + " " + student.name + " - ваша оценка: ");
        int mark = 0;
        if (sc.hasNextInt()) {
            mark = Integer.parseInt(sc.nextLine());
        } else {
            sc.next();
            System.out.println("Не число!");
            return;
        }
        if (mark < 1 || mark > 10) {
            System.out.println("Оценка не может быть");
            return;
        }

        student.mark.add(Integer.valueOf(mark));

    }
}
