import scala.collection.mutable.Map

// The companion objects and class can
// access each other private members

// Companion class of the previous object
class ChecksumAccumulator {

  private var sum = 5
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xff) + 1

}

// Companion object of the previous class
object ChecksumAccumulator {

  private val cache = Map[String, Int]()

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for(c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}

