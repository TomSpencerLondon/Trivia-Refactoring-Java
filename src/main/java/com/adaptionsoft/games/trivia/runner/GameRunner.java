package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import java.util.Random;

// SMELL Most of this code seems to belong in Game - why is it in main?
public class GameRunner {

  private static boolean notAWinner;

  public static void main(String[] args) {
    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");

    Random rand = new Random();

    do {

      aGame.roll(rand.nextInt(5) + 1);

      if (rand.nextInt(9) == 7) {
        notAWinner = aGame.wrongAnswer();
      } else {
        notAWinner = aGame.wasCorrectlyAnswered();
      }


    } while (notAWinner);

  }
}
