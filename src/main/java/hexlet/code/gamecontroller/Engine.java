package hexlet.code.gamecontroller;

import hexlet.code.games.Calculator;
import hexlet.code.games.Cli;
import hexlet.code.games.Exit;
import hexlet.code.games.Even;
import hexlet.code.view.GamesList;

public class Engine extends  RequestNumber {
    public static void gamesSelector(int answer) {
        String strAnswer = String.valueOf(answer);
        if (answer >= 0 && answer < GamesList.getBrainGamesName().size()) {
            switch (strAnswer) {
                case "1":
                    Cli.runGameGreet();
                    break;
                case "2":
                    Even.runGameEven();
                    break;
                case "3":
                    Calculator.runGameCalc();
                case "0": Exit.exitGame();
                default: break;
            }
        } else {
            System.out.println("There are no games under this number! Try again: ");
            gamesSelector(requestInput());
        }
    }
}
