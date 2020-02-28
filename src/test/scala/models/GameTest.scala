package masterMind.models

import org.scalatest.FunSuite

class GameTest extends FunSuite {

  test("propose") {
    val game =
      new Game(1, new SecretCombination(List(Color.B, Color.B, Color.B, Color.B)), new ProposedCombination())
      assert(game.propose(List(Color.O, Color.O, Color.O, Color.O)).equals(new Game(game.getTurn+1, game.getSecretCombination, new ProposedCombination(List(List(Color.O, Color.O, Color.O, Color.O)), List(List(0,0))))))
  }

}
