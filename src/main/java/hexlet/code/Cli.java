package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String greeting = "Welcome to the Brain Games!" + "\n" + "May I have your name? ";
    private static String name = requestName();

    public static String getName() {
        return name;
    }

    public static void getGreeting() {
        System.out.print(greeting); }

    public static void helloName(final String pName) { System.out.println("Hello, " + pName + "!"); }

    protected static String requestName() {
        Scanner scanner = new Scanner(System.in);
        getGreeting();
        String nameTemp = scanner.nextLine();

        while (nameTemp.isEmpty()) {
            System.out.println("You didn't enter a name or specified something bad!" + "\n" + "Try again: ");
            nameTemp = scanner.nextLine();
        }
        return nameTemp;
    }
}
