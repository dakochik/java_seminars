package ru.hse.cs.seminar05;

public interface MyList<T> {

    /**
     * Добавляет элемент в конец списка
     *
     * @param item элемент
     */
    void add(T item);

    /**
     * Возвращает длину списка
     *
     * @return длина списка
     */
    int getSize();

    /**
     * Удаляет элемент по индексу
     *
     * @param index индекс
     */
    void removeAt(int index);

    /**
     * Поверяет принадлежность элемента списку
     *
     * @param item элемент
     * @return true если принадлежит, иначе false
     */
    boolean contains(T item);


}
