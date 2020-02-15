package masterMind.models
import masterMind.views.GestorIO


class SecretCombination(combination: List[Color.Color] = List(1, 2, 3, 4).map(x => Color.RandomColor()), size: Int = 4) {

  private val combination_ = combination

  def getSecret() : List[Color.Color] =
    combination_
}