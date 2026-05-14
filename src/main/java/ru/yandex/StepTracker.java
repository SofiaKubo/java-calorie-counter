package ru.yandex;

import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Некорректный номер месяца. Введите число от 1 до 12.");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30):");
        int day = scanner.nextInt();

        if (day < 1 || day > 30) {
            System.out.println("Некорректный номер дня. Введите число от 1 до 30.");
            return;
        }

        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Количество шагов должно быть положительным числом.");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }
}
