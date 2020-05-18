package ru.academits.kim.array_list_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            ArrayList<String> fileStringsList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                fileStringsList.add(scanner.nextLine());
            }

            System.out.println("Все строки из файла: ");
            System.out.println(fileStringsList);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 55, 47, 56, 48, 78, 98));

        System.out.println("Список из чисел: " + numbers);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }

        System.out.println("Список без четных чисел: " + numbers);

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        ArrayList<Integer> numbersListWithoutRepeats = new ArrayList<>();

        System.out.println("Список из чисел: " + numbersList);

        for (Integer e : numbersList) {
            if (!numbersListWithoutRepeats.contains(e)) {
                numbersListWithoutRepeats.add(e);
            }
        }

        System.out.println("Список из чисел без повторений: " + numbersListWithoutRepeats);
    }
}