package ru.yandex;

import java.util.Scanner;

public class StepTracker {
    private static final int MIN_MONTH_NUMBER = 1;
    private static final int MAX_MONTH_NUMBER = 12;
    private static final int MIN_DAY_NUMBER = 1;
    private static final int MAX_DAY_NUMBER = MonthData.DAYS_IN_MONTH;
    private static final int DEFAULT_GOAL_STEPS_PER_DAY = 10000;

    private final Scanner scanner;
    private final MonthData[] monthsData = new MonthData[MAX_MONTH_NUMBER];
    private final Converter converter = new Converter();
    private int goalByStepsPerDay = DEFAULT_GOAL_STEPS_PER_DAY;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthsData.length; i++) {
            monthsData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        int month = scanner.nextInt();

        if (month < MIN_MONTH_NUMBER || month > MAX_MONTH_NUMBER) {
            System.out.println("Некорректный номер месяца. Введите число от 1 до 12.");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30):");
        int day = scanner.nextInt();

        if (day < MIN_DAY_NUMBER || day > MAX_DAY_NUMBER) {
            System.out.println("Некорректный номер дня. Введите число от 1 до 30.");
            return;
        }

        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Количество шагов должно быть положительным числом.");
            return;
        }

        MonthData monthData = monthsData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель шагов на день:");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Количество шагов должно быть положительным числом.");
            return;
        }

        goalByStepsPerDay = steps;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        int month = scanner.nextInt();

        if (month < MIN_MONTH_NUMBER || month > MAX_MONTH_NUMBER) {
            System.out.println("Некорректный номер месяца. Введите число от 1 до 12.");
            return;
        }

        MonthData monthData = monthsData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();

        monthData.printDaysAndStepsFromMonth();
        System.out.printf("\nВ этом месяце было пройдено: %d шагов\n", sumSteps);

        System.out.printf("\nМаксимальное пройденное количество шагов в этом месяце: %d шагов\n", monthData.maxSteps());

        int averageNumberOfSteps = sumSteps / monthData.days.length;
        System.out.printf("\nСреднее количество шагов в этом месяце: %d шагов\n", averageNumberOfSteps);

        System.out.printf("\nПройденная в этом месяце дистанция: %d км\n", converter.convertToKm(sumSteps));

        System.out.printf("\nКоличество сожжённых в этом месяце килокалорий: %d ккал\n", converter.convertStepsToKilocalories(sumSteps));
        System.out.printf(
                "\nЛучшая серия в этом месяце: %d дней%n",
                monthData.bestSeries(goalByStepsPerDay)
        );

        System.out.println();
    }
}
