package masterMind.models
import scala.util.Random

  object Color extends Enumeration {
    type Color = Value
    val R = Value("R")
    val B = Value("B")
    val Y = Value('Y')
    val G = Value('G')
    val P = Value('P')
    val O = Value('O')

    def RandomColor() : Color = {
      val random = new Random
      Color.values.toList(random.nextInt(Color.values.size))
    }

    def getColor(color : Char) : Color.Color =
      color match {
        case 'B' => Color.B
        case 'R' => Color.R
        case 'Y' => Color.Y
        case 'G' => Color.G
        case 'P' => Color.P
        case 'O' => Color.O
      }

  }


