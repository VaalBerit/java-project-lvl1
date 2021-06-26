package hexlet.code;

public class App {
  public static void main(String[] args) {
    Cli cline = new Cli();

    cline.helloName(cline.getName());
  }
}
