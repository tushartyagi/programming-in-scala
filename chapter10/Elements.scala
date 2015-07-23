abstract class Element {
  // Since this method doesn't have a body, it is taken to be
  // abstract without the abstract qualifier
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}

class ArrayElements(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}

