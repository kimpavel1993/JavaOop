package ru.academits.kim.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount;

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость должна быть не меньше 0. Текущее значение вместимости: " + capacity);
        }

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    public ArrayList(T[] array) {
        size = array.length;

        //noinspection unchecked
        items = (T[]) new Object[size * 2];

        System.arraycopy(array, 0, items, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась");
            }

            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("В коллекцию добавились/удалились элементы");
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0 или больше значения, равного " + (size - 1) + ". Текущее значение индекса:  " + index);
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        return items[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);

        T oldElement = items[index];
        items[index] = element;

        return oldElement;
    }

    public void ensureCapacity(int capacity) {
        if (items.length < capacity) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0 или больше значения, равного " + size + ". Текущее значение индекса:  " + index);
        }

        if (size > items.length) {
            ensureCapacity(items.length * 2);
        }

        System.arraycopy(items, index, items, index + 1, size - index);

        modCount++;
        size++;

        items[index] = element;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        T oldElement = items[index];

        System.arraycopy(items, index + 1, items, index, size - index - 1);

        items[size - 1] = null;

        modCount++;
        size--;

        return oldElement;
    }


    @Override
    public boolean add(T element) {
        add(size, element);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index > -1) {
            remove(index);

            return true;
        }

        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object cItem : c) {
            if (!contains(cItem)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {

            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }

        addAll(size, c);

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0 или больше значения, равного " + size + ". Текущее значение индекса:  " + index);
        }

        if (c.size() == 0) {
            return false;
        }

        ensureCapacity(size + c.size());
        System.arraycopy(items, index, items, index + c.size(), size - index);

        Object[] a = c.toArray();

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(a, 0, items, index, a.length);

        size += c.size();
        modCount++;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) {
            return true;
        }

        boolean isRemoved = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(items[i])) {
                remove(i);
                i--;

                isRemoved = true;
            }
        }

        if (isRemoved) {
            modCount++;
        }

        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() == 0) {
            return true;
        }

        boolean isRemoved = false;

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                i--;

                isRemoved = true;
            }
        }

        if (isRemoved) {
            modCount++;
        }

        return isRemoved;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
        modCount++;
    }

    @Override
    public ListIterator<T> listIterator() {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}