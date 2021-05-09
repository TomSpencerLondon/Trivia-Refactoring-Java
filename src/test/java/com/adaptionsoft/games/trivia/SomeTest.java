package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import java.util.Random;
import org.junit.Test;

public class SomeTest {

	@Test
	public void true_is_true() throws Exception {
    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");

    do {

      aGame.roll(6);

      if (Math.random() == 7) {
        notAWinner = aGame.wrongAnswer();
      } else {
        notAWinner = aGame.wasCorrectlyAnswered();
      }



    } while (notAWinner);


  }
}
