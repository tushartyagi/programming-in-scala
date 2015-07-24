/**
 * Created by 489774 on 7/24/2015.
 */

object Element {
  private class ArrayElement(val contents: Array[String]) extends Element

  // Calling the base constructor here, with parameter
  private class LineElement(s: String) extends Element {
    def contents = Array(s)
    override def height = 1
    override def width = s.length
  }

  private class UniformElement(ch: Char,
                       override val height: Int,
                       override val width: Int)
    extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(ch: Char, height: Int, width: Int): Element =
    new UniformElement(ch, height, width)

  def elem(s: String): Element =
    new LineElement(s)

}

import Element.elem

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (contents.length == 0) 0 else contents(0).length

  override def toString = contents mkString "\n"

  def above(that: Element): Element =
    elem(this.contents ++ that.contents)

  def beside(that: Element): Element =
    elem(
      for(
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      var right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      var bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
}

object Run {
  def main (args: Array[String]) {
    //val ae = new ArrayElement(Array("hello", "world"))
    val ae = Element.elem("Tushar")
    println(ae.height)
    println(ae.width)

    val ue = Element.elem('A', 5, 10)

  }
}