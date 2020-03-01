package masterMind.views

import masterMind.models.{Color, Dimensions, Game}

  object ProposedCombinationView {

    def write(game: Game) = {
      GestorIO.lnwriteln(("Las combinaciones propuestas son: "))
      val turn = game.getTurn
      val combinations = game.getProposedCombination.getCombinations()
      val results = game.getProposedCombination.getResults()
      for (row <- 0 until combinations.size) {
        for(value <- 0 until combinations(row).size){
          GestorIO.write(combinations(row)(value) + "|")
        }
        GestorIO.write(" - Results: ")
        for(result <- 0 until results(row).size){
          GestorIO.write(results(row)(result) + "|")
        }
        GestorIO.writeln("")
      }
    }

    def WriteNumberOfTries(game: Game) =
      GestorIO.lnwriteln(("Tienes " + game.getProposedCombination.numberOfCombinations_ + " intentos"))

    def readRow: List[Color.Color] = {
      ColorView.readColors
    }
  }

