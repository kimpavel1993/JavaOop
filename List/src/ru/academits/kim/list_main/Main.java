package ru.academits.kim.list_main;

import ru.academits.kim.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.insertDataInHead(3);
        list.insertDataInHead(4);
        list.insertDataInHead(5);
        list.insertDataInHead(8);
        list.insertDataByIndex(0, 2);
        list.insertDataByIndex(10, 5);

        System.out.println(list);
        System.out.println("Получение длины списка: " + list.getLength());

        list.copy();
        System.out.println("Копия списка: " + list);

        list.turn();
        System.out.println("Разворот списка: " + list);

        System.out.println("Удаление элемента по индексу: " + list.removeDataByIndex(0));
        System.out.println("Был ли удален элемент из списка: " + list.isRemoteNode(3));
        System.out.println("Получение значения первого элемента: " + list.getHeadData());
        System.out.println("Получение значения элемента по индексу: " + list.getData(1));
        System.out.println("Получение значения элемента по индексу: " + list.getData(3));
    }
}
