package ru.academits.kim.arrayListHome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {

        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            ArrayList<String> list = new ArrayList<>();

            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }

            System.out.println(list);
        }

        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 55, 47, 56, 48, 78, 98, 102));

        for (int i = 0; i < numbers1.size(); i++) {
            if (numbers1.get(i) % 2 == 0) {
                numbers1.remove(i);
                i--;
            }
        }
        System.out.println(numbers1);


        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        ArrayList<Integer> newNumbers2 = new ArrayList<>();

        for (Integer e : numbers2) {
            if (!newNumbers2.contains(e)) {
                newNumbers2.add(e);
            }
        }

        System.out.println(newNumbers2);
    }
}