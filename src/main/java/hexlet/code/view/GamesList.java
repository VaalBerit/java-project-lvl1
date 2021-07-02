package hexlet.code.view;

import hexlet.code.games.Cli;
import hexlet.code.games.Exit;
import hexlet.code.games.Even;
import hexlet.code.games.Calculator;

import java.util.ArrayList;

public class GamesList {
    private static ArrayList<String> brainGamesName = new ArrayList<>();

    public static void initialiazationGameList() {
        brainGamesName.add(Exit.getGameName());
        brainGamesName.add(Cli.getGameName());
        brainGamesName.add(Even.getGameName());
        brainGamesName.add(Calculator.getGameName());
    }

    public static ArrayList<String> getBrainGamesName() {
        return brainGamesName; }
    public static void setBrainGamesName(String pGameName) {
        brainGamesName.add(pGameName); }
}
