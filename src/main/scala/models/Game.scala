package masterMind.models

class Game(secretCombination: SecretCombination = new SecretCombination(), proposedCombinations: List[ProposedCombination] = List()) {

  private val secretCombination_ = secretCombination
  private val proposedCombinations_  = proposedCombinations
  val sizeCombination = 4
  val sizeListGame = 2

  def isFinished: Boolean = true


}