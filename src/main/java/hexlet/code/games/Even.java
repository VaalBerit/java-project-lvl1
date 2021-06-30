package hexlet.code.games;

import java.util.Random;
import hexlet.code.gamecontroller.RequestAnswer;

public class Even extends Cli {
    private static final String GAMEEVEN = "Even";
    private static final String RULES = "Answer \"yes\" if number even otherwise answer \"no\".";
    private static int part = 0;

    private static Random random = new Random();
    private static int number = random.nextInt(1000);

    public static void runGameEven() {
        Cli.helloName(Cli.requestName());
        getRules();
        printAnswer();
    }

    public static String getGameName() {
        return GAMEEVEN;
    }

    public static void getRules() { System.out.println(RULES + "\n"); }

    private static void printQuestion() { System.out.println("Question: " + number); }

    private static void printTrue() {
        System.out.println("Correct!" + "\n");
    }

    private static void printFalse() {
        System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'." + "\n"
                + "Let's try again, " + Cli.getName() + "!" + "\n");
    }

    private static void printCongratulations() {
        System.out.println("Congratulations, " + Cli.getName() + "!");
    }

    private static void resetParamTrue(RequestAnswer requestAnswer) {
        part++;
        number = random.nextInt(1000);
        requestAnswer.resetAnswer();
    }

    private static int resetParamFalse(RequestAnswer requestAnswer) {
        part = 0;
        requestAnswer.resetAnswer();
        return -1;
    }

    private static void printAnswer() {
        String answer;

        for (int i = 0; i < 3; i++) {
            RequestAnswer requestAnswer = new RequestAnswer();
            printQuestion();
            System.out.print("Your answer: ");
            answer = requestAnswer.requestInput();

            if (checkAnswer(answer,number) == true) {
                printTrue();
                resetParamTrue(requestAnswer);
            }
            else {
                printFalse();
                i = resetParamFalse(requestAnswer);
            }
        }
        if (part == 3) {
            printCongratulations();
        }
    }

    private static boolean checkAnswer(String answer, int number) {
        if (answer.equals("yes") && number % 2 == 0) {
            return true;
        }
        else if (answer.equals("no") && number % 2 != 0) {
            return true;
        }
        else return false;
    }
}
