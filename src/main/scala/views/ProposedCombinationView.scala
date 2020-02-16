package masterMind.views

import masterMind.models.Game

  object ProposedCombinationView {

    def write(game: Game) = {
      GestorIO.lnwriteln(("Las combinaciones propuestas son: "))
      val turn = game.getTurn
      val list = game.getProposedCombination.getCombinations(turn)
      for(row <- list){
        GestorIO.write(turn + ". ")
        for (element <- row) {
          GestorIO.write(element + "|")
        }
        GestorIO.writeln("")
      }
    }
    }

