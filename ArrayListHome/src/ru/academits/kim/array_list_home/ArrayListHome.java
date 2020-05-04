package ru.academits.kim.array_list_home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            ArrayList<String> listOfStringsFromFile = new ArrayList<>();

            while (scanner.hasNext()) {
                listOfStringsFromFile.add(scanner.nextLine());
            }

            System.out.println("Все строки из файла: ");
            System.out.println(listOfStringsFromFile);
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 55, 47, 56, 48, 78, 98, 102));

        System.out.println("Список из целых чисел: " + numbers);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }

        System.out.println("Список без целых чисел: " + numbers);

        ArrayList<Integer> oldNumbers = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        ArrayList<Integer> newNumbersWithoutRepeats = new ArrayList<>();

        System.out.println("Список из целых чисел: " + oldNumbers);

        for (Integer e : oldNumbers) {
            if (!newNumbersWithoutRepeats.contains(e)) {
                newNumbersWithoutRepeats.add(e);
            }
        }

        System.out.println("Список из целых чисел без повторений: " + newNumbersWithoutRepeats);
    }
}