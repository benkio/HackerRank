import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {


  def birthdayCakeCandles(n: Int, ar: Array[Int]): Int =  {
    // Complete this function
    val max = ar.max
    ar.count(_ == max)
  }

  val sc = new java.util.Scanner (System.in);
  var n = sc.nextInt();
  var ar = new Array[Int](n);
  for(ar_i <- 0 to n-1) {
    ar(ar_i) = sc.nextInt();
  }
  val result = birthdayCakeCandles(n, ar);
  println(result)

}
