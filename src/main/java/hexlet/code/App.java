package hexlet.code;

public class App {
  public static void main(String[] args) {
    greeting();
    Cli.greetingName(Cli.getName());
  }
  private static void greeting() {
    System.out.println("Welcome to the Brain Games!"); }

}
