package hexlet.code;

public class Exit {
    private static final String gameName = "Exit";

    public static String getGameName() {
        return gameName; }

    public int exitGame() {
        System.out.println("Good luck!");
        return 0; }
}
