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


  override def equals(that: Any): Boolean =
    that match {
      case that: SecretCombination =>
        this.combination_ == that.combination_ && this.size_ == that.size_
      case _ => false
    }
}