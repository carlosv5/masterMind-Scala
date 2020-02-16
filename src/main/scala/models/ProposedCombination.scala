package masterMind.models

class ProposedCombination(combinationSize : Int = 4, numberOfCombinations: Int = 10, combinations : List[List[Color.Color]] = Nil, results: List[Int] = List(0,0)) {
    val results_ = results
    val combinationsSize_ = combinationSize
    val numberOfCombinations_ = numberOfCombinations

  private val combinations_ =
    combinations match {
      case Nil => newCombinations()
      case _ => combinations
    }

  def newCombinations() : List[List[Color.Color]] =
    List.range(0,numberOfCombinations_).map(x => List.range(0, combinationsSize_).map(x=> Color.X))

  def propose(turn: Int): ProposedCombination =
    new ProposedCombination()

  def isWinner(): Boolean =
    false

  def isFinished() : Boolean =
    true

  def getCombinations : List[List[Color.Color]] =
    combinations_
}