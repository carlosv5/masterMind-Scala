package masterMind.models

class ProposedCombination(combinations : List[List[Color.Color]] = Nil, results: List[Int] = List(0,0)) {
  val results_ = results
  val combinationsSize_ = Dimensions.sizeCombination
  val numberOfCombinations_ = Dimensions.sizeListGame
  val combinations_ = combinations

  def newCombinations(): List[List[Color.Color]] =
    List.range(0, numberOfCombinations_).map(x => List.range(0, combinationsSize_).map(x => Color.X))

  def propose(colors: List[Color.Color]) : ProposedCombination = {
    combinations_ match {
      case Nil => new ProposedCombination(List(colors))
      case _ => new ProposedCombination(concatenate(combinations_, colors))
    }
  }

  def concatenate(list1: List[List[Color.Color]], list2 : List[Color.Color]) : List[List[Color.Color]] =
    list1 match {
      case Nil => List(list2)
      case head :: tail => head :: concatenate(tail, list2)
    }


  def isWinner(): Boolean =
    false

  def isFinished(turn : Int) : Boolean =
    isWinner || turn == Dimensions.sizeListGame

  def getCombinations(turn : Int) : List[List[Color.Color]] =
    combinations_
}