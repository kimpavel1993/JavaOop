package ru.academits.kim.hash_table_main;

import ru.academits.kim.hash_table.HashTable;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hashTable = new HashTable<>();
        hashTable.add(100);
        hashTable.add(101);
        hashTable.add(102);
        hashTable.add(103);
        hashTable.add(104);
        hashTable.add(105);
        hashTable.add(106);
        hashTable.add(107);
        hashTable.add(108);
        hashTable.add(109);

        System.out.println(hashTable);
        System.out.println("Наличие элемента в массиве списков: " + hashTable.contains(101));

        Iterator<?> iterator = hashTable.iterator();

        System.out.println("Список по элементам:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Преобразование таблицы в массив: " + Arrays.toString(hashTable.toArray()));

        Integer[] numbers = {34, 88, 92, 232, 542, 755, 23, 34, 666, 1, 2, 7, 5, 343};

        System.out.println("Преобразование списка в массив с добавлением элементов массива: " + Arrays.toString(hashTable.toArray(numbers)));

        ArrayList<Integer> numbersList2 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Random random = new Random();

            numbersList2.add(random.nextInt(100) + 1);
        }

        hashTable.addAll(numbersList2);

        System.out.println("Таблица с добавленными элементами:");
        System.out.println(hashTable);

        ArrayList<Integer> numbersList3= new ArrayList<>(Arrays.asList(100, 101,102, 103, 104, 105, 106, 107, 108, 109));

        System.out.println("Наличие списка в списке: " + hashTable.containsAll(numbersList3));
        System.out.println("Наличие удаленных элементов в списке: " + hashTable.removeAll(numbersList3));

        System.out.println("Список с удаленными элементами:");
        System.out.println(hashTable);

        ArrayList<Integer> numbersList4 = new ArrayList<>(Arrays.asList(1, 2 ,3, 4, 5, 6, 7, 8, 9));

        System.out.println("Сохранение только указанных элементов в списке: " + hashTable.retainAll(numbersList4));

        System.out.println("Список только с указанными элементами:");
        System.out.println(hashTable);

        hashTable.clear();
        System.out.println("Очищение списка: " + hashTable);
    }
}