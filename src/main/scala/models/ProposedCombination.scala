package masterMind.models

class ProposedCombination(combinations : List[List[Color.Color]] = Nil, results: List[List[Int]] = Nil) {
  val results_ = results
  val combinationsSize_ = Dimensions.sizeCombination
  val numberOfCombinations_ = Dimensions.sizeListGame
  val combinations_ = combinations

  def newCombinations(): List[List[Color.Color]] =
    List.range(0, numberOfCombinations_).map(x => List.range(0, combinationsSize_).map(x => Color.X))

  def propose(colors: List[Color.Color]) : ProposedCombination = {
    combinations_ match {
      case Nil => new ProposedCombination(List(colors), calculateResults)
      case _ => new ProposedCombination(concatenate(combinations_, colors), calculateResults)
    }
  }

  def concatenate[A](list1: List[List[A]], list2 : List[A]) : List[List[A]] =
    list1 match {
      case Nil => List(list2)
      case head :: tail => head :: concatenate(tail, list2)
    }

  def calculateResults : List[List[Int]] =
    results_ match {
      case Nil => List(List(0,0))
      case _ => concatenate(results_, List(0,0))
    }


  def isWinner(): Boolean =
    false

  def isFinished(turn : Int) : Boolean =
    isWinner || turn == Dimensions.sizeListGame

  def getCombinations() : List[List[Color.Color]] =
    combinations_

  def getResults() : List[List[Int]] =
    results_
}