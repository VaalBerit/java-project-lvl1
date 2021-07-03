package hexlet.code.games;

import java.util.Random;
import hexlet.code.App;
import hexlet.code.gamecontroller.RequestAnswer;

public class Even extends Cli {
    private static final String GAMENAME = "Even";
    private static final String RULES = "Answer \"yes\" if number even otherwise answer \"no\".";
    private static final int RANDOM_UPPER_LIMIT = 100;

    public static void runGameEven() {
        runGameGreet();
        getRules(RULES);
        movePart();
    }

    public static String getGameName() {
        return GAMENAME;
    }

    public static void getRules(String pRULES) {
        System.out.println(pRULES + "\n"); }

    public static void printCongratulations() {
        System.out.println("Congratulations, " + Cli.getName() + "!");
    }

    public static boolean checkPart(int pPart, int pMaxQuestion) {
        return pPart == pMaxQuestion;
    }

    public static int generateNumber() {
        Random random = new Random();
        int num = random.nextInt(RANDOM_UPPER_LIMIT);
        return num;
    }

    public static void printCorrect() {
        System.out.println("Correct!" + "\n");
    }

    private static void printQuestion(int pNumber) {
        System.out.println("Question: " + pNumber); }

    private static void printAnswer() {
        System.out.print("Your answer: ");
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

    private static void movePart() {
        RequestAnswer requestAnswer = new RequestAnswer();
        int count = 0;
        for (int i = 0; i < App.getMaxQuestion(); i++) {
            int number = generateNumber();

            printQuestion(number);
            printAnswer();

            String answer = RequestAnswer.requestInput();

            if (checkAnswer(answer, number)) {
                printCorrect();
                count++;
                RequestAnswer.resetAnswer();
            } else {
                printFalse(answer);
                count = 0;
                RequestAnswer.resetAnswer();
                break;
            }
        }
        if (checkPart(count, App.getMaxQuestion())) {
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
