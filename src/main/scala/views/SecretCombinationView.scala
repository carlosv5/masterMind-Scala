package masterMind.views

import masterMind.models.Game

  object SecretCombinationView {

    def writeSecret(game: Game) = {
      GestorIO.lnwrite("La combinación secreta es: ")
      for(w <- game.getSecretCombination.getCombination){
        GestorIO.write("X|")
      }
    }

    def write(game: Game) = {
      GestorIO.lnwrite("La combinación secreta era: ")
      for(w <- game.getSecretCombination.getCombination){
        GestorIO.write(w.toString + "|")
      }
    }
  }

