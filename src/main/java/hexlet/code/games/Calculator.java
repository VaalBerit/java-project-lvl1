package hexlet.code.games;

import java.util.Random;
import hexlet.code.App;
import hexlet.code.gamecontroller.RequestNumber;

public class Calculator extends Even {
    private static final String GAMECALC = "Calc";
    private static final String RULES = "What is the result of the expression?\n";
    private static final int RANDOM_UPPER_LIMIT = 100;
    private static final int MAX_ARITHM_OPERATIONS = 3;
    private static int part = 0;

    public static String getGameName() {
        return GAMECALC; }

    public static void runGameCalc() {
        Cli.runGameGreet();
        printRULES(RULES);
        movePart();
    }

    public static void printRULES(String pRULES) {
        System.out.println(pRULES); }

    private static void printQuestion(String pExpression) {
        System.out.println("Question: " + pExpression); }

    private static String printExpression(int number1, int number2, int pArithmOperator) {
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

    private static int resultExpression(int number1, int number2, int pArithmOperator) {
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

    /*private void printErrorDivide() {
        System.out.println("Dividing by zero is not allowed.");
    }*/

    private static void printAnswer() {
        System.out.print("Your answer: ");
    }

    /*private static boolean checkZeroDiv(int pArithmOperator, int number2) {
        if (pArithmOperator == 3 && number2 == 0) {
          return true;
        }
        return false;
    }*/

    private static int generateArithmOperaions() {
        Random random = new Random();
        int arithmOperator = random.nextInt(MAX_ARITHM_OPERATIONS);
        return arithmOperator;
    }

    private static int requestAnswer() {
        RequestNumber requestNumber = new RequestNumber();
        int answer = requestNumber.requestInput();
        return answer;
    }

    private static boolean checkAnswer(int pAnswer, int pResult) {
        return pAnswer == pResult;
    }

    private static void printResult(boolean pCheckAnswer, int pAnswer, int pResultExpression) {
        if (pCheckAnswer) {
            Even.printCorrect();
            part++;
        } else {
            part = 0;
            System.out.println("\"" + pAnswer + "\"" + " is wrong answer ;(. Correct answer was "
                    + "\"" + pResultExpression + "\"" + ".\n"
                    + "Let's try again, " + Cli.getName() + "!");
        }
    }

    private static void movePart() {
        for (int i = 0; i < App.getMaxQuestion(); i++) {
            int number1 = Even.generateNumber();
            int number2 = Even.generateNumber();
            int arithmOperator = generateArithmOperaions();
            //
            int resultExpression = resultExpression(number1, number2, arithmOperator);

            /*while (checkZeroDiv(arithmOperator, number2)) {
                number2 = Even.generateNumber();
            }*/
            printQuestion(printExpression(number1, number2, arithmOperator));
            printAnswer();

            int answer = requestAnswer();

            //printResult(checkAnswer(answer, resultExpression), answer, resultExpression);
            if (Even.checkPart(part, App.getMaxQuestion())) {
                Even.printCongratulations();
            } else {
                printResult(checkAnswer(answer, resultExpression), answer, resultExpression);
            }
        }
    }
}
