package hexlet.code.gamecontroller;

import hexlet.code.games.Cli;
import hexlet.code.games.Exit;
import hexlet.code.games.Even;
import hexlet.code.view.GameList;

public class GameSelection extends  RequestNumber {
    public static void gamesSelector(int answer) {
        if (answer >= 0 && answer < GameList.getBrainGamesName().size()) {
            switch (answer) {
                case 1:
                    Cli.runGameGreet();
                    break;
                case 2:
                    Even.runGameEven();
                    break;
                case 0: Exit.exitGame();
                default: break;
            }
        } else {
            System.out.println("There are no games under this number! Try again: ");
            gamesSelector(requestInput());
        }
    }
}
