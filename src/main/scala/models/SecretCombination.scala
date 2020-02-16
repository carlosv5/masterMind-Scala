package masterMind.models

class SecretCombination(combination: List[Color.Color] = Nil) {

  private val size_ = Dimensions.sizeCombination
  private val combination_ =
    combination match {
      case Nil => getSecret
      case _ => combination
    }

  def getSecret : List[Color.Color] =
    List.range(0,size_).map(x => Color.RandomColor())

  def getCombination : List[Color.Color] =
    combination_
}