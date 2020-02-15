package masterMind.models

class Game(secretCombination: SecretCombination = new SecretCombination(), proposedCombinations: ProposedCombination = new ProposedCombination()) {

  private val secretCombination_ = secretCombination
  private val proposedCombinations_  = proposedCombinations

  def isFinished: Boolean = true


}