package masterMind.models

class ProposedCombination(combinations : List[List[Color.Color]] = Nil, results: List[Int] = List(0,0)) {
  val results_ = results
  val combinationsSize_ = Dimensions.sizeCombination
  val numberOfCombinations_ = Dimensions.sizeListGame

  private val combinations_ =
    combinations match {
      case Nil => newCombinations()
      case _ => combinations
    }

  def newCombinations(): List[List[Color.Color]] =
    List.range(0, numberOfCombinations_).map(x => List.range(0, combinationsSize_).map(x => Color.X))

  def propose(colors: List[Color.Color], turn: Int): ProposedCombination = {
    //Here calculate
    new ProposedCombination(List(colors))
}

  def isWinner(): Boolean =
    false

  def isFinished() : Boolean =
    true

  def getCombinations(turn : Int) : List[List[Color.Color]] =
    combinations_.take(turn)
}