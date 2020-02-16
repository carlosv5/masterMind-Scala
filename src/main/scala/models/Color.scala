package masterMind.models
import scala.util.Random
import masterMind.views.GestorIO

  object Color extends Enumeration {
    type Color = Value
    val RED = Value('R')
    val BLUE = Value('B')
    val EMPTY = Value('-')

    def RandomColor() : Color = {
      val random = new Random
      Color.values.toList(random.nextInt(Color.values.size))
    }


  }


