class ChecksumAccumulator {

  private var sum = 5
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xff) + 1

}
