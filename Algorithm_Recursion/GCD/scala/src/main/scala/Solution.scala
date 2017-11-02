import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {


  def gcd(x: Int, y: Int): Int = (x, y) match {
    // You only need to fill up this function
    // To return the value of the GCD of x and y
    case (x, y) if x == y => x
    case (x, y) if x < y  => gcd(x, y-x)
    case _                => gcd(x-y, y)
  }


  /**This part handles the input/output. Do not change or modify it **/
  def acceptInputAndComputeGCD(pair:List[Int]) = {
    println(gcd(pair.head,pair.reverse.head))
  }

  /** The part relates to the input/output. Do not change or modify it **/
  acceptInputAndComputeGCD(readLine().trim().split(" ").map(x=>x.toInt).toList)

}
