package masterMind.models

class ProposedCombination(combinations : List[List[Color.Color]] = Nil, results: List[List[Int]] = Nil) {
  val results_ = results
  val combinationsSize_ = Dimensions.sizeCombination
  val numberOfCombinations_ = Dimensions.sizeListGame
  val combinations_ = combinations

  def propose(colors: List[Color.Color], secretCombination: SecretCombination) : ProposedCombination = {
    new ProposedCombination(concatenate(combinations_, colors), calculateResults(colors, secretCombination))
  }

  def concatenate[A](list1: List[List[A]], list2 : List[A]) : List[List[A]] =
    list1 match {
      case Nil => List(list2)
      case head :: tail => head :: concatenate(tail, list2)
    }

  def calculateResults(colors : List[Color.Color], secretCombination: SecretCombination) : List[List[Int]] = {
    def calculateBlackResults(list1 : List[Color.Color], list2 : List[Color.Color]) : Int =
      list1 match {
        case Nil => 0
        case head :: tail if head == list2.head => 1 + calculateBlackResults(tail, list2.tail)
        case head :: tail => calculateBlackResults(tail, list2.tail)
      }


    val secCombinations = secretCombination.getCombination
    results_ match {
      case Nil => List(List(calculateBlackResults(colors, secCombinations), 0))
      case _ => concatenate(results_, List(calculateBlackResults(colors, secCombinations), 0))
    }
  }

  def isWinner(): Boolean =
    results_.last(0) == Dimensions.sizeCombination

  def isFinished(turn : Int) : Boolean =
    isWinner || turn == Dimensions.sizeListGame

  def getCombinations() : List[List[Color.Color]] =
    combinations_

  def getResults() : List[List[Int]] =
    results_
}