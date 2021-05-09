package com.codurance.trivia.test;

import com.adaptionsoft.games.uglytrivia.Game;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;

public class GameRunnerGoldenMasterTest {

  private static boolean notAWinner;

  public static void main(String[] args) throws IOException {
    final PrintStream systemOut = System.out;

    // REFACTOR Make current working directory more explicit?
    final File testRunOutputFile = new File("test-data", "golden-master.txt");
    final PrintWriter canvas = new PrintWriter(new FileWriter(testRunOutputFile));
    canvas.println("Hello, world!");
    canvas.flush();
    canvas.close();

    System.setOut(new PrintStream(testRunOutputFile));

    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");

    Random rand = new Random(7777);

    do {
      aGame.roll(rand.nextInt(5) + 1);

      if (rand.nextInt(9) == 7) {
        notAWinner = aGame.wrongAnswer();
      } else {
        notAWinner = aGame.wasCorrectlyAnswered();
      }

    } while (notAWinner);
    System.setOut(systemOut);
  }
}
