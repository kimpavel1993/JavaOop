package ru.academits.kim.list;

import java.util.Objects;

public class List<T> {
    private ListItem<T> head;
    private int length;

    public List() {
        this.head = null;
        this.length = 0;
    }

    public List(T data) {
        this.head = new ListItem<>(data);
        this.length = 1;
    }

    public int getLength() {
        return length;
    }

    public T getHeadData() {
        if (head == null) {
            throw new NullPointerException("Этот список пуст");
        }

        return head.getData();
    }

    private ListItem<T> findByIndex(int index) {
        if (index < 0 || index > length - 1) {
            throw new IllegalArgumentException("Некорректно введен индекс");
        }

        int i = 0;

        ListItem<T> temp = null;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                temp = p;
                break;
            }

            i++;
        }

        return temp;
    }

    public T getData(int index) {
        ListItem<T> node = findByIndex(index);

        return node.getData();
    }

    public T setData(int index, T data) {
        ListItem<T> node = findByIndex(index);
        T oldNode = node.getData();

        node.setData(data);

        return oldNode;

    }

    public T removeDataByIndex(int index) {
        if (index == 0) {
            return removeFirstData();
        }

        ListItem<T> prevNode = findByIndex(index - 1);
        ListItem<T> node = findByIndex(index);

        T removedData = node.getData();
        prevNode.setNext(node.getNext());

        length--;

        return removedData;
    }

    public void insertDataInHead(T data) {
        length++;

        head = new ListItem<>(data, head);
    }

    public void insertDataByIndex(T data, int index) {
        if (index == 0) {
            insertDataInHead(data);
            return;
        }

        length++;

        ListItem<T> prevNode = findByIndex(index - 1);
        ListItem<T> node = new ListItem<>(data);

        node.setNext(prevNode.getNext());
        prevNode.setNext(node);
    }

    public boolean isRemoteNode(T data) {
        if (length == 0) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            removeFirstData();

            return true;
        }

        for (ListItem<T> p = head, prev = head; p != null; prev = p, p = p.getNext()) {
            if (Objects.equals(p.getData(), data)) {
                prev.setNext(p.getNext());

                length--;

                return true;
            }
        }

        return false;
    }

    public T removeFirstData() {
        if (head == null) {
            throw new NullPointerException("Этот список пуст");
        }

        T oldData = head.getData();
        head = head.getNext();

        length--;

        return oldData;
    }

    public void turn() {
        ListItem<T> prevNode = head;
        ListItem<T> node = prevNode.getNext();
        ListItem<T> nextNode = node.getNext();

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            prevNode.setNext(nextNode);
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

    public void copy() {
        if (length == 0) {
            new List<>();
            return;
        }

        List<T> cloneList = new List<>(head.getData());

        ListItem<T> prevNode = cloneList.head;
        ListItem<T> nextNode = head.getNext();

        ListItem<T> node = new ListItem<>(nextNode.getData());

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            prevNode.setNext(node);
            prevNode = node;
        }
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