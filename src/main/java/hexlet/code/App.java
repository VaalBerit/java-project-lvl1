package hexlet.code;

import hexlet.code.gamecontroller.Engine;
import hexlet.code.gamecontroller.RequestNumber;
import hexlet.code.view.GamesList;
import hexlet.code.view.ViewSelections;

public class App {
  private static final int MAX_QUESTION = 3;

  public static void main(String[] args) {

    GamesList gamesList = new GamesList();
    gamesList.initialiazationGameList();

    ViewSelections vs = new ViewSelections();
    vs.printGames(gamesList.getBrainGamesName());

    Engine.gamesSelector(RequestNumber.requestInput());

  }

  public static int getMaxQuestion() {
    return MAX_QUESTION;
  }
}
