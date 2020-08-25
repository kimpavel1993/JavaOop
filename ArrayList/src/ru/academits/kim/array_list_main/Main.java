package ru.academits.kim.array_list_main;

import ru.academits.kim.array_list.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 4};

        ArrayList<Integer> numbersList = new ArrayList<>(numbers);
        numbersList.add(6, 8);

        System.out.println(numbersList);

        ArrayList<String> listStrings = new ArrayList<>(100);
        listStrings.add("One");
        listStrings.add("Two");
        listStrings.add("Three");
        listStrings.add("Four");
        listStrings.add("Five");

        System.out.print(listStrings);

        System.out.println("Длина списка: " + numbersList.size());
        System.out.println("Пустой ли массив: " + numbersList.isEmpty());

        Iterator<?> iterator = numbersList.iterator();

        System.out.println("Список по элементам:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Получение элемента по индексу: " + numbersList.get(1));
        System.out.println("Изменение элемента по индексу: " + numbersList.set(0, 100));
        System.out.println("Удаление элемента по индексу (выдает значение старого элемента): " + numbersList.remove(2));
        System.out.println("Был ли добавлен элемент в конец списка: " + numbersList.add(7));
        System.out.println("Удаление элемента по индексу (выдает значение старого элемента): " + listStrings.remove("3"));
        System.out.println(listStrings);
        System.out.println("Индекс первого вхождения элемента: " + numbersList.indexOf(10));
        System.out.println("Индекс последнего вхождения элемента: " + numbersList.lastIndexOf(4));
        System.out.println("Наличие элемента в списке: " + numbersList.contains(4));

        System.out.println("Список: " + numbersList);

        Integer[] numbers2 = {2, 3, 4};
        ArrayList<Integer> numbersList2 = new ArrayList<>(numbers2);

        System.out.println("Наличие списка в списке: " + numbersList.containsAll(numbersList2));
        System.out.println("Преобразование списка в массив: " + Arrays.toString(numbersList.toArray()));

        Integer[] numbers3 = {34, 88, 92, 232, 542, 755, 23, 34, 666, 1, 2, 7, 5, 343};

        System.out.println("Преобразование списка в массив с добавлением элементов массива: " + Arrays.toString(numbersList.toArray(numbers3)));

        System.out.println("Наличие добавленных элементов в списке: " + numbersList.addAll(numbersList2));
        System.out.println("Список с добавленными элементами: " + numbersList);

        System.out.println("Наличие добавленных элементов по индексу в списке: " + numbersList.addAll(2, numbersList2));
        System.out.println("Список с добавленными элементами: " + numbersList);

        System.out.println("Наличие удаленных элементов в списке: " + numbersList.removeAll(numbersList2));
        System.out.println("Список с удаленными элементами: " + numbersList);

        Integer[] numbers4 = {7, 5};
        ArrayList<Integer> numbersList4 = new ArrayList<>(numbers4);

        System.out.println("Сохранение только указанных элементов в списке: " + numbersList.retainAll(numbersList4));
        System.out.println("Список только с указанными элементами: " + numbersList);

        numbersList.clear();
        System.out.println("Очищение списка: " + numbersList);
    }
}