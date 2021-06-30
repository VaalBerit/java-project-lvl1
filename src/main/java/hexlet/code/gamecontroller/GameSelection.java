package hexlet.code.gamecontroller;

import hexlet.code.games.Cli;
import hexlet.code.games.Exit;
import hexlet.code.games.Even;

public class GameSelection extends  RequestNumber {
    public static void gamesSelector(int answer) {
        switch (answer) {
            case 1:
                Cli.helloName(Cli.requestName());
                break;
            case 2:
                Even.runGameEven();
                break;
            case 0: Exit.exitGame();
            default: break;
        }
    }
}
