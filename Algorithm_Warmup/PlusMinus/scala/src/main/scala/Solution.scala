import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  val sc = new java.util.Scanner (System.in);
  var n = sc.nextInt();
  var arr = new Array[Int](n);
  for(arr_i <- 0 to n-1) {
    arr(arr_i) = sc.nextInt();
  }
  val (numPositive, zeros, numNegative) =
    arr.foldRight((0.0, 0.0, 0.0))((i, t) => i match {
                                     case 0 => (t._1, t._2 + 1, t._3)
                                     case x if x > 0 => (t._1 + 1, t._2, t._3)
                                     case x if x < 0 => (t._1, t._2, t._3 + 1)
                                   })
  println(numPositive/n)
  println(numNegative/n)
  println(zeros/n)
}
