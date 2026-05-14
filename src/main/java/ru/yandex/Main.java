package ru.yandex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    System.out.println("Выполняется команда 2");
                    break;
                case 3:
                    System.out.println("Выполняется команда 3");
                    break;
                case 4:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определённый месяц");
        System.out.println("4 - Выйти из приложения");
    }
}
