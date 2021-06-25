package hexlet.code;

import java.util.Scanner;
import hexlet.code.*;

import static hexlet.code.Cli.requestName;

public class App {
  public static void main(String[] args) {
    greeting();
    Cli.greetingName(Cli.getName());
  }
  private static void greeting() { System.out.println("Welcome to the Brain Games!"); }

}
