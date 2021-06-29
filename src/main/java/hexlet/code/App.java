package hexlet.code;

public class App {
  public static void main(String[] args) {
    GameList gameList = new GameList();
    ViewSelections vs = new ViewSelections();
    Cli cli = new Cli();

    gameList.initialiazationGameList();
    vs.printGames(gameList.getBrainGamesName());
    cli.helloName(cli.requestName());
  }
}
