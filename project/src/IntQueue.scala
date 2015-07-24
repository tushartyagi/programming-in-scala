/**
 * Created by 489774 on 7/24/2015.
 */
import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

class BasicIntQueue extends IntQueue with Doubling{
  private val buf = new ArrayBuffer[Int]()
  def get() = buf.remove(0)
  abstract override def put(x: Int) { buf += x }
}


