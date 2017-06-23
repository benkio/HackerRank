import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  def aVeryBigSum(n: Int, ar: Array[Long]): Long =  {
    // Complete this function
    if (n == 0) 0 else ar.reduce(_ + _)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var ar = new Array[Long](n);
    for(ar_i <- 0 to n-1) {
      ar(ar_i) = sc.nextLong();
    }
    val result = aVeryBigSum(n, ar);
    println(result)
  }

}
