
package masterMind

import masterMind.models.Game
import masterMind.views.{GameView, GestorIO}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

    GameView.write(game)
    do {

      GameView.write(game)
    } while (!game.isFinished)
    GestorIO.write("You lose!")
  }
}