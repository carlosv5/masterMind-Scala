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

    def calculateWhiteResults(list1 : List[Color.Color], list2 : List[Color.Color]) : Int = {
      list1 match {
        case Nil => 0
        case head :: tail if head == list2.head => 1 + calculateWhiteResults(tail, list2.tail)
        case head :: tail => calculateWhiteResults(tail, list2)
      }
    }

    def auxCalculateWhites(list1 : List[Color.Color], list2 : List[Color.Color]) : List[Color.Color] =
      list1 match {
        case Nil => Nil
        case head :: tail if head == list2.head => auxCalculateWhites(tail, list2.tail)
        case head::tail => head :: auxCalculateWhites(tail, list2.tail)
      }

    val secCombinations = secretCombination.getCombination
    val auxList1 = auxCalculateWhites(colors, secCombinations)
    val auxList2 = auxCalculateWhites(secCombinations, colors)
    results_ match {
      case Nil => List(List(calculateBlackResults(colors, secCombinations), calculateWhiteResults(auxList1, auxList2)))
      case _ => concatenate(results_, List(calculateBlackResults(colors, secCombinations), calculateWhiteResults(auxList1, auxList2)))
    }
  }

  def isWinner(): Boolean =
    results_.last(0) == combinationsSize_

  def isFinished(turn : Int) : Boolean = {
    isWinner || turn > numberOfCombinations_
  }

  def getCombinations() : List[List[Color.Color]] =
    combinations_

  def getResults() : List[List[Int]] =
    results_

  override def equals(that: Any): Boolean =
    that match {
      case that: ProposedCombination =>
        this.combinations_ == that.combinations_ && this.results_ == that.results_ && this.combinationsSize_ == that.combinationsSize_ && this.numberOfCombinations_ == that.numberOfCombinations_
      case _ => false
    }
}