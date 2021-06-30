package hexlet.code.gamecontroller;

import java.util.Scanner;

public class RequestNumber {
    private static int answer = 0;

    public static int requestInput() {
        Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                answer = (scanner.nextInt());
            }
        return answer;
    }
}
