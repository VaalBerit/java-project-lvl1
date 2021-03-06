package hexlet.code.gamecontroller;

import java.util.Scanner;

public class RequestAnswer {
    private static String answer = "";

    public static String requestInput() {
        Scanner scanner = new Scanner(System.in);
        while (answer.isEmpty()) {
            if (scanner.hasNextLine() && (scanner.hasNext("yes") || scanner.hasNext("no"))) {
                answer = scanner.nextLine();
            } else {
                //break;
                System.out.println("You answered incorrectly, only \"yes\" or \"no\" are accepted!" + "\n"
                        + "Try again: ");
                scanner.nextLine();
            }
        }
        return answer;
    }
    public static final void resetAnswer() {
        answer = "";
    }
}
