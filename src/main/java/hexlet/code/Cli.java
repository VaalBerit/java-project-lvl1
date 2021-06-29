package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final String gameName = "Greet";
    private static final String greeting = "Welcome to the Brain Games!" + "\n" + "May I have your name? ";
    private static String playerName;

    public static String getName() {
        return playerName;
    }

    public static String getGameName() {
        return gameName;
    }

    public static void getGreeting() {
        System.out.print(greeting); }

    public static void helloName(final String pName) {
        System.out.println("Hello, " + pName + "!"); }

    protected static String requestName() {
        Scanner scanner = new Scanner(System.in);
        getGreeting();
        String name = scanner.nextLine();

        while (name.isEmpty()) {
            System.out.println("You didn't enter a name or specified something bad!" + "\n" + "Try again: ");
            name = scanner.nextLine();
        }
        return name;
    }
}
