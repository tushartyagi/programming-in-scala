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

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1)}
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

