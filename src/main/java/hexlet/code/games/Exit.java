package hexlet.code;
/**
 * This class for exit game.
 */

public final class Exit {
    private static final String GAMEEXIT = "Exit";

    public static String getGameName() {
        return GAMEEXIT; }

    public int exitGame() {
        System.out.println("Good luck!");
        return 0; }
}
