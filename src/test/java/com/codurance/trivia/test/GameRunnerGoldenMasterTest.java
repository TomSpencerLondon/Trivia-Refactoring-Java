package com.codurance.trivia.test;

import static org.junit.Assert.assertArrayEquals;

import com.adaptionsoft.games.uglytrivia.Game;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Random;
import org.junit.Test;

public class GameRunnerGoldenMasterTest {

  private static boolean notAWinner;

  @Test
  public void game_works() throws IOException {
    final PrintStream systemOut = System.out;

    // REFACTOR Make current working directory more explicit?
    final File testRunOutputFile = new File("test-data", "test-run.txt");

    System.setOut(new PrintStream(testRunOutputFile));
    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");

    int seed = 7777;
    Random rand = new Random(seed);

    do {
      aGame.roll(rand.nextInt(5) + 1);

      if (rand.nextInt(9) == 7) {
        notAWinner = aGame.wrongAnswer();
      } else {
        notAWinner = aGame.wasCorrectlyAnswered();
      }

    } while (notAWinner);
    System.setOut(systemOut);

    File test = new File("test-data", "test-run.txt");
    File master = new File("test-data", "golden-master.txt");

    byte[] first = Files.readAllBytes(test.toPath());
    byte[] second = Files.readAllBytes(master.toPath());
    assertArrayEquals(first, second);
  }

}
