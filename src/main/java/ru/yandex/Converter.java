package ru.yandex;

public class Converter {
    private static final int STEP_LENGTH_CM = 75;
    private static final int CM_PER_KM = 100_000;
    private static final int CALORIES_PER_STEP = 50;
    private static final int CALORIES_PER_KILOCALORIE = 1_000;

    int convertToKm(int steps) {
        return steps * STEP_LENGTH_CM / CM_PER_KM;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * CALORIES_PER_STEP / CALORIES_PER_KILOCALORIE;
    }
}
