package ru.hse.cs.seminar06;

public interface MyList<T> {

    /**
     * Получение элемента по индексу
     *
     * @param index индекс
     * @return элемент
     */
    T get(int index);

    /**
     * Добавление элемента в лист
     *
     * @param element элемент
     */
    void add(T element);

    /**
     * Удаление элемента по индексу
     *
     * @param index индекс
     * @return true, если элемент по индексу был удален, иначе false
     */
    boolean removeAt(int index);

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
}
