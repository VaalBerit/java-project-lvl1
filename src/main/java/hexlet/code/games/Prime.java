package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.gamecontroller.RequestAnswer;

public class Prime extends Even {
    private static final String GAMENAME = "Prime";
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int RANDOM_UPPER_LIMIT = 150;

    public static void runGameEven() {
        runGameGreet();
        getRules(RULES);
        movePart();
    }

    public static String getGameName() {
        return GAMENAME;
    }

    private static void movePart() {
        int count = 0;
        for (int i = 0; i < App.getMaxQuestion(); i++) {
            int number = generateNumber(RANDOM_UPPER_LIMIT);

            printQuestion(number);
            printAnswer();
            String answer = RequestAnswer.requestInput();

                if (checkAnswer(answer, checkNumberIsPrime(number))) {
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

    private static boolean checkNumberIsPrime(int pNumber) {
        return pNumber != 0 && pNumber != 1 && checkRemainderOfDivision(pNumber);
    }

    private static boolean checkRemainderOfDivision(int pNumber) {
        int count = 0;
        for (int i = 1; i <= pNumber; i++) {
            if (pNumber % i == 0) {
                count++;
            } else {
                continue;
            }
        }
        if (count == 2) {
            return true;
        } else {
            count = 0;
            return false;
        }
    }
    protected static boolean checkAnswer(String answer, boolean pCheckNumberIsPrime) {
        if (answer.equals("yes") && pCheckNumberIsPrime) {
            return true;
        } else {
            return answer.equals("no") && !pCheckNumberIsPrime;
        }
    }
}
