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
     * Возвращает элемент коллекции по указаному индексу
     *
     * @param index индекс
     * @return элемент коллекции
     * @throws IndexOutOfBoundsException если индекс находился за пределами колекции
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (!checkBounds(index)) {
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
    public void put(T item) {
        // Если Массив почти полностью заполнился, увеличиваем его в DEFAULT_INCREASE раз
        if (pointer == array.length - 1) {
            resize(array.length * COEFFICIENT_RESIZE);
        }
        array[pointer++] = item;
    }


    /**
     * Удаляет элемент коллекции по заданому индексу
     *
     * @param index индекс
     * @throws IndexOutOfBoundsException если индекс находился за пределами коллекции
     */
    @Override
    public void removeAt(int index) {

        if (!checkBounds(index)) {
            throw new IndexOutOfBoundsException("Индекс находился вне границ массива!");
        }

        System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer--] = null;

        if (array.length > INIT_SIZE && pointer < array.length / COEFFICIENT_RESIZE) {
            resize(array.length / COEFFICIENT_RESIZE);
        }
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

    /**
     * Очистка коллекции
     */
    @Override
    public void clear() {
        array = new Object[INIT_SIZE];
        pointer = 0;
    }


    /**
     * Проверяет содержится ли индекс в пределах коллекции
     *
     * @param index индекс
     * @return true если содержится, иначе false
     */
    private boolean checkBounds(int index) {
        return index >= 0 && index < size();
    }

    /**
     * Вспомогательный метод для масштабирования размера массива
     *
     * @param newLength новая длина массива
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
