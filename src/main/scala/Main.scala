
package masterMind

import masterMind.models.Game
import masterMind.views.{GameView, GestorIO}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

    GameView.writeInit(game)
    do {
      GameView.write(game)
    } while (!game.isFinished)
    GameView.writeFinished(game)
    if(game.isWinner)
    GestorIO.lnwrite("You win!")
    else
      GestorIO.lnwrite("You lose!")
  }
}