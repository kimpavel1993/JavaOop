package ru.academits.kim.array_list_main;

import ru.academits.kim.array_list.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 4};

        ArrayList<Integer> listOfNumbers = new ArrayList<>(numbers);

        System.out.println(listOfNumbers);

        ArrayList<String> listOfStrings = new ArrayList<>(100);
        listOfStrings.add("One");
        listOfStrings.add("Two");
        listOfStrings.add("Three");
        listOfStrings.add("Four");
        listOfStrings.add("Five");

        System.out.print(listOfStrings);

        System.out.println("Длина списка: " + listOfNumbers.size());
        System.out.println("Пустой ли массив: " + listOfNumbers.isEmpty());

        Iterator iterator = listOfNumbers.iterator();

        System.out.println("Список по элементам:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Получение элемента по индексу: " + listOfNumbers.get(1));
        System.out.println("Изменение элемента по индексу: " + listOfNumbers.set(0, 100));
        System.out.println("Удаление элемента по индексу (выдает значение старого элемента): " + listOfNumbers.remove(2));
        System.out.println("Был ли добавлен элемент в конец списка: " + listOfNumbers.add(7));
        System.out.println("Индекс первого вхождения элемента: " + listOfNumbers.indexOf(10));
        System.out.println("Индекс последнего вхождения элемента: " + listOfNumbers.lastIndexOf(4));
        System.out.println("Наличие элемента в списке: " + listOfNumbers.contains(4));

        System.out.println("Список: " + listOfNumbers);

        Integer[] numbers2 = {2, 3, 4};
        ArrayList<Integer> listOfNumbers2 = new ArrayList<>(numbers2);

        System.out.println("Наличие списка в списке: " + listOfNumbers.containsAll(listOfNumbers2));
        System.out.println("Преобразование списка в массив: " + Arrays.toString(listOfNumbers.toArray()));

        Integer[] numbers3 = {34, 88, 92, 232, 542, 755, 23, 34, 666, 1, 2, 7, 5, 343};

        System.out.println("Преобразование списка в массив с добавлением элементов массива: " + Arrays.toString(listOfNumbers.toArray(numbers3)));

        System.out.println("Наличие добавленных элементов в списке: " + listOfNumbers.addAll(listOfNumbers2));
        System.out.println("Список с добавленными элементами: " + listOfNumbers);

        System.out.println("Наличие добавленных элементов по индексу в списке: " + listOfNumbers.addAll(2, listOfNumbers2));
        System.out.println("Список с добавленными элементами: " + listOfNumbers);

        System.out.println("Наличие удаленных элементов в списке: " + listOfNumbers.removeAll(listOfNumbers2));
        System.out.println("Список с удаленными элементами: " + listOfNumbers);

        Integer[] numbers4 = {7, 5};
        ArrayList<Integer> listOfNumbers3 = new ArrayList<>(numbers4);

        System.out.println("Сохранение только указанных элементов в списке: " + listOfNumbers.retainAll(listOfNumbers3));
        System.out.println("Список только с указанными элементами: " + listOfNumbers);

        listOfNumbers.clear();
        System.out.println("Очищение списка: " + listOfNumbers);
    }
}