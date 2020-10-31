package ru.hse.cs.seminar05;

import java.util.Objects;

public class LinkedList<T> implements MyList<T> {

    /**
     * Поле размер массива
     */
    private int size;

    /**
     * Первый элемент последовательности
     */
    Node<T> head;

    /**
     * Последний элемент последовательности
     */
    Node<T> tail;


    /**
     * Добавляет элемент в конец последовательности
     *
     * @param item - элемент
     */
    @Override
    public void add(T item) {
        ++size;

        // Если список инициализируется впервые,
        // добавляем новый блок как начальный и конечный для списка
        if (head == null) {
            head = new Node<>(item);
            tail = head;
            return;
        }

        // Создаем блок, где придыдущем элементов является последний элемент списка
        Node<T> newNode = new Node<>(item, tail);
        // Назначаем для последнего элемента списка следующий только что созданный
        tail.next = newNode;
        // Помечаем только что созданный элемент, как последний
        tail = newNode;
    }

    /**
     * Возвращает количество элементов последовательности
     *
     * @return количество элементов
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Удаляет элемент по индексу
     *
     * @param index индекс удаляемого объекта
     * @throws IndexOutOfBoundsException выбрасыввается если индекс находился вне границ массива
     */
    @Override
    public void removeAt(int index) throws IndexOutOfBoundsException {
        // Получение блока по индексу
        Node<T> nodeToRemove = getNode(index);
        // Если в списке всего 1 элемент, удаляем
        if (nodeToRemove == head && nodeToRemove == tail) {
            head = null;
            tail = null;
            // Если удаляется первый элемент
        } else if (nodeToRemove == head) {
            head = head.next;
            head.previous = null;
            // Если удаляется последний
        } else if (nodeToRemove == tail) {
            tail = tail.previous;
            tail.next = null;
            // Если удаляется центральный
        } else {
            Node<T> previousNode = nodeToRemove.previous;
            Node<T> nextNode = nodeToRemove.next;
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        }

        nodeToRemove.dispose();
        --size;
    }


    /**
     * Проверяет принадлежит ли элемент последовательности
     *
     * @param item элемент
     * @return true если принадлежит, иначе false
     */
    @Override
    public boolean contains(T item) {
        Node<T> inputNode = new Node<>(item);
        Node<T> currentNode = this.head;
        for (int i = 0; i < size; i++) {
            if (currentNode.equals(inputNode)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Возвращает элемент по индексу
     *
     * @param index индекс
     * @return элемент
     */
    public T get(int index) {
        Node<T> node = getNode(index);
        return node.data;
    }

    /**
     * Возвращает блок листа по индексу
     *
     * @param index индекс
     * @return блок
     * @throws IndexOutOfBoundsException если индекс находится вне границ листа
     */
    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс находился вне границ массива");
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; ++i) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }


    /**
     * Класс блоков из которых сделан лист
     *
     * @param <T> типизированный параметн
     */
    class Node<T> {

        /**
         * Информация которую содержит блок
         */
        private final T data;

        /**
         * следующий блок относительно данного
         */
        private Node<T> next;

        /**
         * предыдущий блок относительно данного
         */
        private Node<T> previous;

        /**
         * Создает экземпляр класса
         *
         * @param data информация содержащаяся в блоке
         * @see #Node(Object, Node)
         * @see #Node(Object, Node, Node)
         */
        public Node(T data) {
            this(data, null);
        }

        /**
         * Создает экземпляр класса
         *
         * @param data     информация содержащаяся в блоке
         * @param previous предыдущий блок в списке
         * @see #Node(Object)
         * @see #Node(Object, Node, Node)
         */
        public Node(T data, Node<T> previous) {
            this(data, previous, null);
        }

        /**
         * Создает экземпляр класса
         *
         * @param data     информация содержащаяся в блоке
         * @param previous предыдущий блок в списке
         * @param next     следующий блок в списке
         * @see #Node(Object)
         * @see #Node(Object, Node)
         */
        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }


        /**
         * Определяет сравнение объектов
         *
         * @param o объект для сравнивания с данным
         * @return true если объекты одинаковые, иначе false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return data.equals(node.data);
        }

        /**
         * Нужен для сравнения объектов
         *
         * @return значение hash функции
         */
        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        /**
         * Удаляет мусор
         */
        public void dispose() {
            next = null;
            previous = null;
        }

    }
}
