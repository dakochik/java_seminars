package ru.hse.cs.seminar06;


public class ArrayList<T> implements MyList<T> {

    /**
     * Константа - начальный размер коллекции
     */
    private final int INIT_SIZE = 16;
    /**
     * Константа - увелечение/уменьшение объема коллекции в столько то раз
     */
    private final int COEFFICIENT_RESIZE = 2;
    /**
     * Поле - храенние элементов коллекции
     */
    private Object[] array = new Object[INIT_SIZE];
    /**
     * Поле - указатель на крайнюю незаполненую ячейку коллекции
     */
    private int pointer = 0;


    /**
     * Возвращает элемент по указанному индексу
     *
     * @param index индекс
     * @return элемент
     * @throws IndexOutOfBoundsException если индекс находится вне границ массива
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Индекс находился вне границ массива!");
        }

        return (T) array[index];
    }

    /**
     * Добавляет элемент в конец списка
     * При достижении границы массива, увеличивает емкость в {@link #COEFFICIENT_RESIZE} раз
     *
     * @param item элемент
     */
    @Override
    public void add(T item) {
        // Если Массив почти полностью заполнился, увеличиваем его в DEFAULT_INCREASE раз
        if (pointer == array.length - 1) {
            resize(array.length * COEFFICIENT_RESIZE);
        }
        array[pointer++] = item;
    }

    /**
     * Удаление элемента по индексу
     *
     * @param index индекс
     * @return true, если элемент по индексу был удален, иначе false
     */
    @Override
    public boolean removeAt(int index) {

        if (index < 0 || index >= size()) {
            return false;
        }

        System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer--] = null;

        if (array.length > INIT_SIZE && pointer < array.length / COEFFICIENT_RESIZE) {
            resize(array.length / COEFFICIENT_RESIZE);
        }

        return true;
    }

    /**
     * Проверяет содержится ли элемент в коллекции
     *
     * @param element проверяемый элемент
     * @return true, если элемент содержиться, иначе false
     */
    @Override
    public boolean contains(T element) {

        for (int i = 0; i < size(); i++) {

            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Получение количества элементов коллекции
     *
     * @return количество элементов коллекции
     */
    @Override
    public int size() {
        return pointer;
    }


    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
