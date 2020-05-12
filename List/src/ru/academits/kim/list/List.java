package ru.academits.kim.list;

import ru.academits.kim.list_item.ListItem;

import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> {
    private ListItem<T> head;
    private int length;

    public List() {
    }

    public List(T data) {
        head = new ListItem<>(data);
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Этот список пуст");
        }

        return head.getData();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0 или больше значения, равному длине списка - 1. Текущее значение индекса:  " + index);
        }
    }

    private ListItem<T> getByIndex(int index) {
        checkIndex(index);

        int i = 0;

        ListItem<T> tempNode = null;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                tempNode = p;
                break;
            }

            i++;
        }

        return tempNode;
    }

    public T getData(int index) {
        return getByIndex(index).getData();
    }

    public T setData(int index, T data) {
        ListItem<T> node = getByIndex(index);
        T oldNode = node.getData();

        node.setData(data);

        return oldNode;
    }

    public T removeByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> previousNode = getByIndex(index - 1);
        ListItem<T> node = previousNode.getNext();

        T removedData = node.getData();
        previousNode.setNext(node.getNext());

        length--;

        return removedData;
    }

    public void addFirst(T data) {
        length++;

        head = new ListItem<>(data, head);
    }

    public void insertByIndex(T data, int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0 или больше значения, равному длине списка. Текущее значение индекса:  " + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        length++;

        ListItem<T> previousNode = getByIndex(index - 1);
        ListItem<T> node = new ListItem<>(data);

        node.setNext(previousNode.getNext());
        previousNode.setNext(node);
    }

    public boolean remove(T data) {
        if (length == 0) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            removeFirst();

            return true;
        }

        for (ListItem<T> p = head.getNext(), prev = head; p != null; prev = p, p = p.getNext()) {
            if (Objects.equals(p.getData(), data)) {
                prev.setNext(p.getNext());

                length--;

                return true;
            }
        }

        return false;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Этот список пуст");
        }

        T oldData = head.getData();
        head = head.getNext();

        length--;

        return oldData;
    }

    public void turn() {
        if (length <= 1) {
            return;
        }

        ListItem<T> previousNode = head;
        ListItem<T> node = previousNode.getNext();
        ListItem<T> nextNode = node.getNext();

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            previousNode.setNext(nextNode);
            node.setNext(head);
            head = node;
            node = nextNode;

            i++;

            if (i == length - 1) {
                break;
            }

            nextNode = node.getNext();
        }
    }

    public List<T> copy() {
        if (length == 0) {
            return new List<>();
        }

        List<T> cloneList = new List<>(head.getData());

        ListItem<T> cloneNode = cloneList.head;

        for (ListItem<T> p = head.getNext(); p != null; p = p.getNext()) {
            ListItem<T> node = new ListItem<>(p.getData());

            cloneNode.setNext(node);
            cloneNode = node;
        }

        return cloneList;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder("{");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}