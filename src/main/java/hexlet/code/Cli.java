package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String name = requestName();

    protected static String requestName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");

        String nameTemp = scanner.nextLine();

        while (nameTemp.isEmpty()) {
            System.out.println("You didn't enter a name or specified something bad! \n Try again: ");
            nameTemp = scanner.nextLine();
        }
        return nameTemp;
    }
    public static String getName() {
        return name;
    }
    public static void greetingName(final String pName) {
        System.out.println("Hello, " + pName + "!");
    }
}
