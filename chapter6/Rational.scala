// The class taking class parameters
class Rational(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val num = n / g
  val den = d / g

  // Creating an auxillary constructor
  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    new Rational(
      num * that.den + that.num * den,
      den * that.den
    )

  def + (that: Int): Rational =
    new Rational(num + that * den, den)

  def - (that: Rational): Rational =
    new Rational(
      num * that.den - that.num * den,
      den * that.den
    )

  def - (that: Int): Rational =
    new Rational(num - that * den, den)

  def * (that: Rational): Rational =
    new Rational(
      num * that.num,
      den * that.den
    )

  def * (that: Int): Rational =
    new Rational(num * that * den, den)

  def / (that: Rational): Rational =
    this * that.inverse

  def / (that: Int): Rational =
    new Rational(num, den * that)

  def inverse(): Rational =
    new Rational(den, num)

  def lessThan(that: Rational) =
    num * that.den < that.num * den

  def max(that: Rational) =
    if(this.lessThan(that)) that else this

  override def toString = num + "/" + den

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  
}
