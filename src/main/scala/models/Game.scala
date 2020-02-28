package masterMind.models

object Dimensions {
  val sizeCombination = 4
  val sizeListGame = 10
}

class Game(turn: Int = 1, secretCombination: SecretCombination = new SecretCombination(), proposedCombinations : ProposedCombination = new ProposedCombination()) {
  private val turn_ = turn
  private val secretCombination_ = secretCombination
  private val proposedCombinations_  = proposedCombinations

  def isFinished: Boolean = proposedCombinations_.isFinished(turn_)
  def isWinner: Boolean = proposedCombinations_.isWinner()

  def propose(colors : List[Color.Color]): Game = {
    val newTurn = turn_ + 1
    val newProposedCombinations = proposedCombinations_.propose(colors, secretCombination_)
    new Game(newTurn, secretCombination_, newProposedCombinations)
  }

  def getSecretCombination: SecretCombination =
    secretCombination_

  def getProposedCombination: ProposedCombination =
    proposedCombinations_

  def getTurn : Int =
    turn_

  override def equals(that: Any): Boolean =
    that match {
      case that: Game => this.turn_ == that.turn_ && this.proposedCombinations_ == that.proposedCombinations_ && this.secretCombination_ == that.secretCombination_
      case _ => false
    }

}