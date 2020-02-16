package masterMind.views

import masterMind.models.Game

object GameView {

  def write(game:Game) = {
    ProposedCombinationView.write(game)
  }

  def writeInit(game:Game) = {
    SecretCombinationView.writeSecret(game)
  }
  def writeFinished(game:Game) = {
    SecretCombinationView.write(game)
  }
}
