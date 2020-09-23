package ru.academits.kim.array_list_main;

import ru.academits.kim.array_list.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers1 = {1, 2, 3, 4, 5, 6};

        ArrayList<Integer> numbersList1 = new ArrayList<>(numbers1);
        numbersList1.add(6, 8);

        System.out.println(numbersList1);

        ArrayList<String> stringsList = new ArrayList<>(100);
        stringsList.add("One");
        stringsList.add("Two");
        stringsList.add("Three");
        stringsList.add("Four");
        stringsList.add("Five");

        System.out.print(stringsList);
        System.out.println("Длина списка: " + numbersList1.size());
        System.out.println("Пустой ли массив: " + numbersList1.isEmpty());

        Iterator<?> iterator = numbersList1.iterator();

        System.out.println("Список по элементам:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Получение элемента по индексу: " + numbersList1.get(1));
        System.out.println("Изменение элемента по индексу: " + numbersList1.set(0, 100));
        System.out.println("Удаление элемента по индексу (выдает значение старого элемента): " + numbersList1.remove(2));
        System.out.println("Был ли добавлен элемент в конец списка: " + numbersList1.add(7));
        System.out.println("Был ли удален элемент из списка: " + stringsList.remove("One"));
        System.out.println(stringsList);
        System.out.println("Индекс первого вхождения элемента: " + numbersList1.indexOf(10));
        System.out.println("Индекс последнего вхождения элемента: " + numbersList1.lastIndexOf(4));
        System.out.println("Наличие элемента в списке: " + numbersList1.contains(4));
        System.out.println("Список: " + numbersList1);

        Integer[] numbers2 = {22, 33, 44};
        ArrayList<Integer> numbersList2 = new ArrayList<>(numbers2);

        System.out.println("Наличие списка в списке: " + numbersList1.containsAll(numbersList2));
        System.out.println("Преобразование списка в массив: " + Arrays.toString(numbersList1.toArray()));

        Integer[] numbers3 = {34, 88, 92, 232, 542, 755, 23, 34, 666, 1, 2, 7, 5, 343};

        System.out.println("Преобразование списка в массив с добавлением элементов массива: " + Arrays.toString(numbersList1.toArray(numbers3)));
        System.out.println("Наличие добавленных элементов в списке: " + numbersList1.addAll(numbersList2));
        System.out.println("Список с добавленными элементами: " + numbersList1);
        System.out.println("Наличие добавленных элементов по индексу в списке: " + numbersList1.addAll(2, numbersList2));
        System.out.println("Список с добавленными элементами: " + numbersList1);
        System.out.println("Наличие удаленных элементов в списке: " + numbersList1.removeAll(numbersList2));
        System.out.println("Список с удаленными элементами: " + numbersList1);

        Integer[] numbers4 = {7, 5};
        ArrayList<Integer> numbersList4 = new ArrayList<>(numbers4);

        System.out.println("Сохранение только указанных элементов в списке: " + numbersList1.retainAll(numbersList4));
        System.out.println("Список только с указанными элементами: " + numbersList1);

        numbersList1.clear();
        System.out.println("Очищение списка: " + numbersList1);
    }
}