package hexlet.code.games;
/**
 * This class for exit game.
 */

public final class Exit {
    private static final String GAMEEXIT = "Exit";

    public static String getGameName() {
        return GAMEEXIT; }

    public static void exitGame() {
        System.out.println("Good luck!");
    }
}
