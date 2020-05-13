package ru.academits.kim.lambdas_main;

import ru.academits.kim.lambdas.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Иван", 12),
                new Person("Сергей", 33),
                new Person("Петр", 22),
                new Person("Ольга", 15),
                new Person("Анна", 25),
                new Person("Ольга", 64)
        ));

        List<String> uniqueNames = list.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Список уникальных имен: " + uniqueNames);

        String uniqueNamesFormat = list.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Имена: " + uniqueNamesFormat);

        List<String> personsUnder18 = list.stream()
                .filter(p -> p.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Список людей младше 18 лет: " + personsUnder18);

        double averageAge = list.stream()
                .filter(x -> x.getAge() < 18)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        System.out.println("Средний возраст этих людей: " + averageAge);

        Map<String, Double> personsByAverageAge = list.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println("Список уникальных имен со средним возрастом:");

        personsByAverageAge.forEach((name, age) -> System.out.printf("Имя: %s, Средний возраст: %s%n", name, age));

        List<Person> persons = list.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .collect(Collectors.toList());

        System.out.println("Список людей в возрасте от 20 до 45 в порядке убывания:");
        System.out.println(persons);
    }
}