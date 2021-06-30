package hexlet.code.games;

import java.util.Random;
import hexlet.code.gamecontroller.RequestAnswer;

public class Even extends Cli {
    private static final String GAMEEVEN = "Even";
    private static final String RULES = "Answer \"yes\" if number even otherwise answer \"no\".";
    private static final int RANDOM_UPPER_LIMIT = 1000;
    private static final int MAX_PART = 3;
    private static int part = 0;

    private static final Random RANDOM = new Random();
    private static int number = RANDOM.nextInt(RANDOM_UPPER_LIMIT);

    public static void runGameEven() {
        Cli.runGameGreet();
        getRules();
        printAnswer();
    }

    public static String getGameName() {
        return GAMEEVEN;
    }

    public static void getRules() {
        System.out.println(RULES + "\n"); }

    private static void printQuestion() {
        System.out.println("Question: " + number); }

    private static void printTrue() {
        System.out.println("Correct!" + "\n");
    }

    private static void printFalse(String answer) {
        if (answer.equals("yes")) {
            System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'." + "\n"
                    + "Let's try again, " + Cli.getName() + "!");
        } else {
            System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'." + "\n"
                    + "Let's try again, " + Cli.getName() + "!");
        }
    }

    private static void printCongratulations() {
        System.out.println("Congratulations, " + Cli.getName() + "!");
    }

    private static void resetParamTrue(RequestAnswer requestAnswer) {
        part++;
        number = RANDOM.nextInt(RANDOM_UPPER_LIMIT);
        requestAnswer.resetAnswer();
    }

    private static void resetParamFalse(RequestAnswer requestAnswer) {
        part = 0;
        requestAnswer.resetAnswer();
    }

    private static void printAnswer() {
        String answer;
        RequestAnswer requestAnswer = new RequestAnswer();

        for (int i = 0; i < MAX_PART; i++) {
            printQuestion();
            System.out.print("Your answer: ");
            answer = RequestAnswer.requestInput();
            if (checkAnswer(answer, number)) {
                printTrue();
                resetParamTrue(requestAnswer);
            } else {
                printFalse(answer);
                i = -1;
                resetParamFalse(requestAnswer);
                break;
            }
        }
        if (part == MAX_PART) {
            printCongratulations();
        }
    }

    private static boolean checkAnswer(String answer, int pNumber) {
        if (answer.equals("yes") && pNumber % 2 == 0) {
            return true;
        } else {
            return answer.equals("no") && pNumber % 2 != 0;
        }
    }
}
