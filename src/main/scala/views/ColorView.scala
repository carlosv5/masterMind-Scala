package masterMind.views {

  import masterMind.models.Color

object ColorView {

  def readColors(): List[Color.Color] = {
    val stringColors = GestorIO.readString("Colors(4): ")
    getColors(stringColors)
  }

  def writePossibleColors() = {
    GestorIO.write("Los colores que puedes usar son: ")
    for (value <- 0 until Color.values.toList.size) {
      GestorIO.write(Color.values.toList(value) + "|")
    }
  }

  def getColors(colors: String): List[Color.Color] = {
    colors match {
      case "" => Nil
      case _ => Color.getColor(colors.head) :: getColors((colors.tail))
    }
  }
}

}
