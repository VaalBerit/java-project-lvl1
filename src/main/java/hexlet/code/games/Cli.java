package hexlet.code.games;

import java.util.Scanner;

public class Cli {
    private static final String GAMEGREET = "Greet";
    private static final String GREETINGPLAYER = "Welcome to the Brain Games!" + "\n" + "May I have your name? ";
    private static String playerName;

    public static void runGameGreet() {
        helloName(requestName());
    }

    public static String getName() {
        return playerName;
    }

    public static String getGameName() {
        return GAMEGREET;
    }

    public static void getGreeting() {
        System.out.print(GREETINGPLAYER); }

    public static void helloName(final String pName) {
        System.out.println("Hello, " + pName + "!" + "\n"); }

    public static String requestName() {
        Scanner scanner = new Scanner(System.in);
        getGreeting();
        String name = scanner.nextLine();

        while (name.isEmpty()) {
            System.out.println("You didn't enter a name or specified something bad!" + "\n" + "Try again: ");
            name = scanner.nextLine();
        }
        if (name != null) {
            playerName = name;
        }
        return name;
    }
}
