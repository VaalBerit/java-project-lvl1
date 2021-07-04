package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.gamecontroller.RequestNumber;

import java.util.Random;

public class Progression extends Calculator {
    private static final String GAMENAME = "Progression";
    private static final String RULES = "What number is missing in the progression?\n";
    private static final int RANDOM_UPPER_LIMIT = 50;
    private static final int MIN_RANGE = 5;
    private static final int MAX_RANGE = 10;

    public static void runGameProgression() {
        runGameGreet();
        printRULES(RULES);
        movePart();
    }

    public static String getGameName() {
        return GAMENAME; }

    public static int getRandomNumberRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void movePart() {
        int count = 0;
        for (int i = 0; i < App.getMaxQuestion(); i++) {
            int[] randomArrays = getRandomArraysProgression();
            int skipIndex = generateNumber(randomArrays.length);

            printQuestion(printArrays(randomArrays, skipIndex));
            printAnswer();
            int answer = RequestNumber.requestInput();
            if (checkAnswer(answer, randomArrays[skipIndex])) {
                printCorrect();
                count++;
                if (checkPart(count, App.getMaxQuestion())) {
                    printCongratulations();
                    break;
                } else {
                    continue;
                }
            } else {
                printResult(checkAnswer(answer, randomArrays[skipIndex]), answer, randomArrays[skipIndex]);
                count = 0;
                break;
            }
        }
    }

    private static void printQuestion(StringBuilder pStringBuilder) {
        System.out.println("Question: " + pStringBuilder);
    }

    private static int[] getRandomArraysProgression() {
        int[] randomArraysProg = new int[getRandomNumberRange(MIN_RANGE, MAX_RANGE)];
        randomArraysProg[0] = generateNumber(RANDOM_UPPER_LIMIT);
        int partD = generateNumber(MAX_RANGE);
        for (int i = 1; i < randomArraysProg.length; i++) {
            randomArraysProg[i] = randomArraysProg[i - 1] + partD;
        }
        return randomArraysProg;
    }

    public static StringBuilder printArrays(int[] pArrays, int skipNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < pArrays.length; i++) {
            if (i == pArrays.length - 1 && skipNumber != i) {
                stringBuilder.append(pArrays[i]);
                break;
            } else if (i == pArrays.length - 1 && skipNumber == i) {
                stringBuilder.append("..");
            } else {
                if (skipNumber == i) {
                    stringBuilder
                            .append("..")
                            .append(" ");
                } else {
                    stringBuilder
                            .append(pArrays[i])
                            .append(" ");
                }
            }
        }
        return stringBuilder;
    }

}
