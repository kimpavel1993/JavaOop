package ru.academits.kim.hash_table;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private final ArrayList<T>[] lists;
    private int size;
    private int modCount;

    public HashTable(int arrayLength) {
        if (arrayLength <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть > 0. Текущее значение вместимости: " + arrayLength);
        }

        //noinspection unchecked
        lists = new ArrayList[arrayLength];
    }

    public HashTable() {
        //noinspection unchecked
        lists = new ArrayList[10];
    }

    private int getIndex(Object o) {
        if (o == null) {
            return 0;
        }

        return Math.abs(o.hashCode() % lists.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int index = getIndex(o);

        if (lists[index] == null) {
            return false;
        }

        return lists[index].contains(o);
    }

    private class MyTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int currentModCount = modCount;
        private int arrayIndex = 0;
        private int listIndex = 0;

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
                throw new ConcurrentModificationException("Коллекция изменилась");
            }

            currentIndex++;

            for (int i = arrayIndex; i < lists.length; i++) {
                arrayIndex = i;

                if (lists[i] != null && !lists[i].isEmpty()) {
                    T element = lists[i].get(listIndex);

                    listIndex++;

                    if (listIndex == lists[i].size()) {
                        arrayIndex++;
                        listIndex = 0;
                    }

                    return element;
                }
            }

            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyTableIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        int i = 0;

        for (T e : this) {
            array[i] = e;

            i++;
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(toArray(), size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T t) {
        int index = getIndex(t);

        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }

        lists[index].add(t);

        modCount++;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);

        if (lists[index] == null) {
            return false;
        }

        if (lists[index].remove(o)) {
            modCount++;
            size--;

            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }

        for (T element : c) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) {
            return false;
        }

        boolean isRemoved = false;

        for (ArrayList<T> e : lists) {
            if (e != null) {
                int sizeBeforeRemove = e.size();

                if (e.removeAll(c)) {
                    isRemoved = true;

                    size -= sizeBeforeRemove - e.size();
                }
            }
        }

        if (isRemoved) {
            modCount++;
        }

        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (isEmpty()) {
            return false;
        }

        if (c.size() == 0) {
            clear();

            return true;
        }

        boolean isRetained = false;

        for (ArrayList<T> e : lists) {
            if (e != null) {
                int sizeBeforeRetain = e.size();

                if (e.retainAll(c)) {
                    isRetained = true;

                    size -= sizeBeforeRetain - e.size();
                }
            }
        }

        if (isRetained) {
            modCount++;
        }

        return isRetained;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }

        Arrays.fill(lists, null);

        size = 0;
        modCount++;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Пустая таблица";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (ArrayList<T> e : lists) {
            if (e != null && e.size() > 0) {
                int i = 0;

                for (T element : e) {
                    int index = getIndex(element);

                    if (i == 0) {
                        String result = index + ". " + element + ", ";

                        stringBuilder.append(result);

                        i++;
                    } else {
                        String result = element + ", ";

                        stringBuilder.append(result);
                    }
                }

                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                stringBuilder.append(System.lineSeparator());
            }
        }

        return stringBuilder.toString();
    }
}