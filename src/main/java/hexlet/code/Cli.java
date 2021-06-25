package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String name = requestName();

    protected static String requestName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");

        String name = scanner.nextLine();

        while (name.isEmpty()) {
            System.out.println("You didn't enter a name or specified something bad! \n Try again: ");
            name = scanner.nextLine();
        }
        return name;
    }
    public static String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public static void greetingName(final String name) {
        System.out.println("Hello, " + name + "!");
    }
}
