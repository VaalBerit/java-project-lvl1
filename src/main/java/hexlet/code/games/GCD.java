package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.gamecontroller.RequestNumber;

public class GCD extends Calculator {
    private static final String GAMENAME = "GCD";
    private static final String RULES = "Find the greatest common divisor of given numbers.\n";

    public static void runGameGCD() {
        runGameGreet();
        printRULES(RULES);
        movePart();
    }

    public static String getGameName() {
        return GAMENAME; }

    private static String printExpression(int pNumber1, int pNumber2) {
        return pNumber1 + " " + pNumber2;
    }

    private static int resultGCD(int pNumber1, int pNumber2) {
        while (pNumber2 != 0) {
            int tmp = pNumber1 % pNumber2;
            pNumber1 = pNumber2;
            pNumber2 = tmp;
        }
        return pNumber1;
    }

    private static void movePart() {
        int count = 0;
        for (int i = 0; i < App.getMaxQuestion(); i++) {

            int number1 = generateNumber();
            int number2 = generateNumber();
            int result = resultGCD(number1, number2);

            printQuestion(printExpression(number1, number2));
            printAnswer();
            int answer = RequestNumber.requestInput();

            if (checkAnswer(answer, result)) {
                count++;
                printResult(checkAnswer(answer, result), answer, result);
                if (checkPart(count, App.getMaxQuestion())) {
                    printCongratulations();
                    break;
                } else {
                    continue;
                }
            } else {
                printResult(checkAnswer(answer, result), answer, result);
                break;
            }
        }
    }
}
