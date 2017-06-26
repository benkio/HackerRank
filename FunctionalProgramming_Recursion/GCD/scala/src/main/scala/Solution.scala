import scala.io.StdIn
import java.io.PrintWriter

object Solution {

  def gcd(x: Int, y: Int): Int = (x, y) match {
    case (a, b) if a == b => a
    case (a, b) if (a > b) => gcd(a-b, b)
    case (a, b) if (a < b) => gcd(a, b-a)
  }


  /**This part handles the input/output. Do not change or modify it **/
  def acceptInputAndComputeGCD(pair:List[Int]) = {
    println(gcd(pair.head,pair.reverse.head))
  }

  def main(args: Array[String]) {
    /** The part relates to the input/output. Do not change or modify it **/
    acceptInputAndComputeGCD(readLine().trim().split(" ").map(x=>x.toInt).toList)

  }
}
