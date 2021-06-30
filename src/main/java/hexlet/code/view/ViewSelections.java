package hexlet.code.view;

import java.util.ArrayList;

public final class ViewSelections {
    private static final String ENTERNUMBER = "Please enter the game number and press Enter.";

    public static void printGames(ArrayList<String> brainGamesName) {
        System.out.println(ENTERNUMBER);
        for (int i = 1; i < brainGamesName.size(); i++) {
            System.out.println(i + " - " + brainGamesName.get(i));
        }
        System.out.println(0 + " - " + brainGamesName.get(0));
    }
}
