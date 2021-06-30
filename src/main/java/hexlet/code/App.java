package hexlet.code;

import hexlet.code.gamecontroller.GameSelection;
import hexlet.code.gamecontroller.RequestNumber;
import hexlet.code.view.GameList;
import hexlet.code.view.ViewSelections;

public class App {
  public static void main(String[] args) {
    GameList gameList = new GameList();
    gameList.initialiazationGameList();

    ViewSelections vs = new ViewSelections();
    vs.printGames(gameList.getBrainGamesName());
    GameSelection.gamesSelector(RequestNumber.requestInput());

  }
}
