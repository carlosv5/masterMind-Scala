package masterMind.models

object Dimensions {
  val sizeCombination = 4
  val sizeListGame = 2
}

class Game(turn: Int = 0, secretCombination: SecretCombination = new SecretCombination(Dimensions.sizeCombination), proposedCombinations : ProposedCombination = new ProposedCombination(Dimensions.sizeCombination, Dimensions.sizeListGame)) {
  private val turn_ = turn
  private val secretCombination_ = secretCombination
  private val proposedCombinations_  = proposedCombinations

  def isFinished: Boolean = proposedCombinations_.isFinished()
  def isWinner: Boolean = proposedCombinations_.isWinner()

  def propose: Game = {
    val newTurn = turn_ + 1
    val newProposedCombinations = proposedCombinations_.propose(newTurn)
    new Game(newTurn, secretCombination_, newProposedCombinations)
  }

  def getSecretCombination: SecretCombination =
    secretCombination_

}