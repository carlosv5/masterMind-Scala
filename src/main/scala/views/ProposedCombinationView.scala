package masterMind.views

import masterMind.models.{Color, Dimensions, Game}

  object ProposedCombinationView {

    def write(game: Game) = {
      GestorIO.lnwriteln(("Las combinaciones propuestas son: "))
      val turn = game.getTurn
      val list = game.getProposedCombination.getCombinations(turn)
      for (row <- list) {
        for (element <- row) {
          GestorIO.write(element + "|")
        }
        GestorIO.writeln("")
      }
    }

    def readRow: List[Color.Color] = {
      ColorView.readColors
    }
  }

