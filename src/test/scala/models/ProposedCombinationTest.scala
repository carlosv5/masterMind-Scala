package masterMind.models

import org.scalatest.FunSuite

class ProposedCombinationTest extends FunSuite {

  test("isFinishedTrueBecauseOfResults") {
    val proposedCombination =
      new ProposedCombination(List(List(Color.O, Color.O, Color.O, Color.O)), List(List(4,0)))
    assert(proposedCombination.isFinished(2) == true)
  }

  test("isFinishedTrueBecauseOfTurn") {
    val proposedCombination =
      new ProposedCombination(Nil, List(List(2,0)))
    assert(proposedCombination.isFinished(Dimensions.sizeListGame+1) == true)
  }

  test("isFinishedFalseBecauseOfResultsNotReachedAndIsNotTheLastTurn") {
    val proposedCombination =
      new ProposedCombination(List(List(Color.O, Color.O, Color.O, Color.O)), List(List(3,0)))
    assert(proposedCombination.isFinished(Dimensions.sizeListGame - 1) == false)
  }

  test("isWinnerTrue") {
    val proposedCombination =
      new ProposedCombination(List(List(Color.O, Color.O, Color.O, Color.O)), List(List(4,0)))
    assert(proposedCombination.isWinner() == true)
  }

  test("isWinnerFalse") {
    val proposedCombination =
      new ProposedCombination(List(List(Color.O, Color.O, Color.O, Color.O)), List(List(0,0)))
    assert(proposedCombination.isWinner() == false)
  }

  test("calculateResultsAllBlacks") {
    val proposedCombination =
      new ProposedCombination(Nil,Nil)
    assert(proposedCombination.calculateResults(List(Color.O, Color.O, Color.O, Color.O),
      new SecretCombination(List(Color.O, Color.O, Color.O, Color.O))) == List(List(4,0)))
  }

  test("calculateResults2Blacks2Whites") {
    val proposedCombination =
      new ProposedCombination(Nil,Nil)
    assert(proposedCombination.calculateResults(List(Color.B, Color.R, Color.P, Color.O),
      new SecretCombination(List(Color.B, Color.R, Color.O, Color.P))) == List(List(2,2)))
  }

  test("calculateResultsAllWhites") {
    val proposedCombination =
      new ProposedCombination(Nil,Nil)
    assert(proposedCombination.calculateResults(List(Color.B, Color.R, Color.P, Color.O),
      new SecretCombination(List(Color.R, Color.B, Color.O, Color.P))) == List(List(0,4)))
  }
}