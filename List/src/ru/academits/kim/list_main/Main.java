package ru.academits.kim.list_main;

import ru.academits.kim.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(8);
        list.insertByIndex(0, 2);
        list.insertByIndex(10, 5);

        System.out.println(list);
        System.out.println("Получение длины списка: " + list.getLength());

        System.out.println("Копия списка: " + list.copy());

        list.turn();
        System.out.println("Разворот списка: " + list);

        System.out.println("Удаление элемента по индексу: " + list.removeByIndex(0));
        System.out.println("Был ли удален элемент из списка: " + list.remove(3));
        System.out.println("Получение значения первого элемента: " + list.getFirst());
        System.out.println("Получение значения элемента по индексу: " + list.getData(1));
        System.out.println("Получение значения элемента по индексу: " + list.getData(3));
        System.out.println("Изменение значения элемента по индексу: " + list.setData(3, 5));
        System.out.println("Получение значения элемента по индексу: " + list.getData(3));
    }
}