package masterMind.models
import scala.util.Random

  object Color extends Enumeration {
    type Color = Value
    val RED = Value('R')
    val BLUE = Value('B')

    def RandomColor() : Color = {
      val random = new Random
      Color.values.toList(random.nextInt(Color.values.size))
    }


  }


