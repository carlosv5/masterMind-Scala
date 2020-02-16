package masterMind.views

object GestorIO {

  def write(string:String):Unit =
    print(string)

  def writeln(string:String):Unit =
    print(string + "\n")

  def lnwrite(string:String):Unit =
  print("\n" + string)

  def lnwriteln(string:String):Unit =
    print("\n" + string + "\n")

  def readString(title:String):String = {
    print(s"$title: ")
    scala.io.StdIn.readLine()
  }

}
