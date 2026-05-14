# Calorie Counter

A simple console-based Java application for tracking daily steps and printing monthly statistics.

## Features

- Add the number of steps for a specific day.
- Change the daily step goal.
- Show statistics for a selected month.
- Exit the application through the menu.

## Monthly Statistics

The application shows:

- steps for each day of the selected month;
- total steps for the month;
- maximum steps in one day;
- average daily steps;
- distance in kilometers;
- burned kilocalories;
- best streak of consecutive days when the step goal was reached or exceeded.

## Calculation Rules

- 1 step = 75 cm
- 1 step = 50 calories
- 1 kilocalorie = 1000 calories
- each month has 30 days
- the application stores data for 12 months
- calculations use integer arithmetic

## Project Structure

```text
src/main/java/ru/yandex/
├── Main.java
├── StepTracker.java
├── MonthData.java
└── Converter.java
```

## Classes

### Main

Starts the application, prints the menu, reads user commands, and calls the required methods.

### StepTracker

Stores monthly data, handles user input, changes the daily goal, and prints statistics.

### MonthData

Stores step data for one month and calculates monthly statistics.

### Converter

Converts steps to kilometers and kilocalories.

## Menu

```text
1 - Add steps for a specific day
2 - Change daily step goal
3 - Show statistics for a specific month
4 - Exit
```

## Input Validation

The application checks that:

- the month number is from 1 to 12;
- the day number is from 1 to 30;
- the number of steps is positive;
- the new daily goal is positive;
- the selected menu command exists.

The current implementation expects numeric input from the console.
