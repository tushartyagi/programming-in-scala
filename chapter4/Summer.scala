import ChecksumAccumulator.calculate

object Main {
  def main(args: Array[String]) {
    for(season <- List("This", "that", "everything"))
      println(season + ": " + calculate(season))
  }
}
