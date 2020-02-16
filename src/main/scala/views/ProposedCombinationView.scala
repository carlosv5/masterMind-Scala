package masterMind.views

import masterMind.models.Game

  object ProposedCombinationView {

    def write(game: Game) = {
      GestorIO.lnwriteln(("Las combinaciones propuestas son: "))
      val list = game.getProposedCombination.getCombinations
      for(row <- list){
        GestorIO.write(list.indexOf(row) + ". ")
        for (element <- row) {
          GestorIO.write(element + "|")
        }
        GestorIO.writeln("")
      }
    }
    }

