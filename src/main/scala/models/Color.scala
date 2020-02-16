package masterMind.models
import scala.util.Random
import masterMind.views.GestorIO

  object Color extends Enumeration {
    type Color = Value
    val R = Value("R")
    val B = Value("B")
    val X = Value('X')

    def RandomColor() : Color = {
      val random = new Random
      Color.values.toList(random.nextInt(Color.values.size))
    }

  }


