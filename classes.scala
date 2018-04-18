// class ChecksumAccumulator {
//   private var sum = 0
//
//   def add(b: Byte): Unit = {
//     sum += b
//   }
//
//   def checksum(): Int = {
//     return ~(sum & 0xFF) + 1
//   }
// }

// The above is the same as:

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

var cs = new ChecksumAccumulator
var firstSum = cs.checksum()
println(firstSum)
cs.add(3)
var sum = cs.checksum()
println(sum)
