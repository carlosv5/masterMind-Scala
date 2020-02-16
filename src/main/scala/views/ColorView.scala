package masterMind.views {

  import masterMind.models.Color

object ColorView {

  def readColors(): List[Color.Color] = {
    val stringColors = GestorIO.readString("Colors(4): ")
    getColors(stringColors)
  }

  def getColors(colors: String): List[Color.Color] = {
    colors match {
      case "" => Nil
      case _ => Color.getColor(colors.head) :: getColors((colors.tail))
    }
  }
}

}
