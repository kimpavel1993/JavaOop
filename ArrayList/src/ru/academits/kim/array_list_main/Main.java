package ru.academits.kim.array_list_main;

import ru.academits.kim.array_list.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 4};

        ArrayList<Integer> listNumbers = new ArrayList<>(numbers);

        System.out.println(listNumbers);

        ArrayList<String> listStrings = new ArrayList<>(100);
        listStrings.add("One");
        listStrings.add("Two");
        listStrings.add("Three");
        listStrings.add("Four");
        listStrings.add("Five");

        System.out.print(listStrings);

        System.out.println("Длина списка: " + listNumbers.size());
        System.out.println("Пустой ли массив: " + listNumbers.isEmpty());

        Iterator iterator = listNumbers.iterator();

        System.out.println("Список по элементам:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Получение элемента по индексу: " + listNumbers.get(1));
        System.out.println("Изменение элемента по индексу: " + listNumbers.set(0, 100));
        System.out.println("Удаление элемента по индексу (выдает значение старого элемента): " + listNumbers.remove(2));
        System.out.println("Был ли добавлен элемент в конец списка: " + listNumbers.add(7));
        System.out.println("Индекс первого вхождения элемента: " + listNumbers.indexOf(10));
        System.out.println("Индекс последнего вхождения элемента: " + listNumbers.lastIndexOf(4));
        System.out.println("Наличие элемента в списке: " + listNumbers.contains(4));

        System.out.println("Список: " + listNumbers);

        Integer[] numbers2 = {2, 3, 4};
        ArrayList<Integer> listNumbers2 = new ArrayList<>(numbers2);

        System.out.println("Наличие списка в списке: " + listNumbers.containsAll(listNumbers2));
        System.out.println("Преобразование списка в массив: " + Arrays.toString(listNumbers.toArray()));

        Integer[] numbers3 = {34, 88, 92, 232, 542, 755, 23, 34, 666, 1, 2, 7, 5, 343};

        System.out.println("Преобразование списка в массив с добавлением элементов массива: " + Arrays.toString(listNumbers.toArray(numbers3)));

        System.out.println("Наличие добавленных элементов в списке: " + listNumbers.addAll(listNumbers2));
        System.out.println("Список с добавленными элементами: " + listNumbers);

        System.out.println("Наличие добавленных элементов по индексу в списке: " + listNumbers.addAll(2, listNumbers2));
        System.out.println("Список с добавленными элементами: " + listNumbers);

        System.out.println("Наличие удаленных элементов в списке: " + listNumbers.removeAll(listNumbers2));
        System.out.println("Список с удаленными элементами: " + listNumbers);

        Integer[] numbers4 = {7, 5};
        ArrayList<Integer> listOfNumbers3 = new ArrayList<>(numbers4);

        System.out.println("Сохранение только указанных элементов в списке: " + listNumbers.retainAll(listOfNumbers3));
        System.out.println("Список только с указанными элементами: " + listNumbers);

        listNumbers.clear();
        System.out.println("Очищение списка: " + listNumbers);
    }
}