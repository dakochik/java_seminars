package ru.hse.cs.seminar06;

public interface MyList<T> {

    /**
     * Возвращает элемент коллекции по указаному индексу
     *
     * @param index индекс
     * @return элемент коллекции
     * @throws IndexOutOfBoundsException если индекс находился за пределами колекции
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Добавление элемента в лист
     *
     * @param element элемент
     */
    void put(T element);

    /**
     * Удаляет элемент коллекции по заданому индексу
     *
     * @param index индекс
     * @throws IndexOutOfBoundsException если индекс находился за пределами коллекции
     */
    void removeAt(int index) throws IndexOutOfBoundsException;

    /**
     * Проверяет содержится ли элемент в коллекции
     *
     * @param element проверяемый элемент
     * @return true, если элемент содержиться, иначе false
     */
    boolean contains(T element);

    /**
     * Получение размера коллекции
     *
     * @return размер коллекции
     */
    int size();

    /**
     * Очистка коллекции
     */
    void clear();
}
