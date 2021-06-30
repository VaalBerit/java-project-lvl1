package hexlet.code.view;

import hexlet.code.games.Cli;
import hexlet.code.games.Exit;

import java.util.ArrayList;

public class GameList {
    private static ArrayList<String> brainGamesName = new ArrayList<>();

    public static void initialiazationGameList() {
        brainGamesName.add(Exit.getGameName());
        brainGamesName.add(Cli.getGameName());
    }

    public static ArrayList<String> getBrainGamesName() {
        return brainGamesName;
    }
}
