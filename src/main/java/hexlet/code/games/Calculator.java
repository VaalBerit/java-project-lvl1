package hexlet.code.games;

import java.util.Random;
import hexlet.code.App;
import hexlet.code.gamecontroller.RequestNumber;

public class Calculator extends Even {
    private static final String GAMENAME = "Calc";
    private static final String RULES = "What is the result of the expression?\n";
    private static final int MAX_ARITHM_OPERATIONS = 3;
    private static final int RANDOM_UPPER_LIMIT = 100;

    public static String getGameName() {
        return GAMENAME; }

    public static void runGameCalc() {
        runGameGreet();
        printRULES(RULES);
        movePart();
    }

    public static void printRULES(final String pRULES) {
        System.out.println(pRULES); }

    public static void printQuestion(final String pExpression) {
        System.out.println("Question: " + pExpression); }

    public static void printAnswer() {
        System.out.print("Your answer: ");
    }

    public static boolean checkAnswer(final int pAnswer, final int pResult) {
        return pAnswer == pResult;
    }

    public static void printResult(final boolean pCheckAnswer, final int pAnswer, final int pResultExpression) {
        if (pCheckAnswer) {
            printCorrect();
        } else {
            System.out.println("\"" + pAnswer + "\"" + " is wrong answer ;(. Correct answer was "
                    + "\"" + pResultExpression + "\"" + ".\n"
                    + "Let's try again, " + Cli.getName() + "!");
        }
    }

    private static String printExpression(final int number1, final int number2, final int pArithmOperator) {
        switch (pArithmOperator) {
            case 0:
                return  number1 + " + " + number2;
            case 1:
                return  number1 + " - " + number2;
            case 2:
                return  number1 + " * " + number2;
            /*case 3:
                return  number1 + " / " + number2;*/
            default: return  number1 + " + " + number2;
        }
    }

    private static int resultExpression(final int number1, final int number2, final int pArithmOperator) {
        switch (pArithmOperator) {
            case 0:
                return  number1 + number2;
            case 1:
                return number1 - number2;
            case 2:
                return number1 * number2;
            /*case 3:
                if (number2 != 0) { return number1 / number2; }*/
            default: return number1 + number2;
        }
    }

    private static int generateArithmOperaions() {
        Random random = new Random();
        int arithmOperator = random.nextInt(MAX_ARITHM_OPERATIONS);
        return arithmOperator;
    }

    private static void movePart() {
        int count = 0;
        for (int i = 0; i < App.getMaxQuestion(); i++) {
            int number1 = Even.generateNumber(RANDOM_UPPER_LIMIT);
            int number2 = Even.generateNumber(RANDOM_UPPER_LIMIT);
            int arithmOperator = generateArithmOperaions();
            int resultExpression = resultExpression(number1, number2, arithmOperator);

            printQuestion(printExpression(number1, number2, arithmOperator));
            printAnswer();
            int answer = RequestNumber.requestInput();

            if (checkAnswer(answer, resultExpression)) {
                printResult(checkAnswer(answer, resultExpression), answer, resultExpression);
                count++;
                if (checkPart(count, App.getMaxQuestion())) {
                    printCongratulations();
                    break;
                } else {
                    continue;
                }
            } else {
                printResult(checkAnswer(answer, resultExpression), answer, resultExpression);
                count = 0;
                break;
            }
        }
    }
}
