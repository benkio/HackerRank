import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {
  val sc = new java.util.Scanner (System.in);
  var arr = new Array[Int](5);
  for(arr_i <- 0 to 5-1) {
    arr(arr_i) = sc.nextInt();
  }
  val (min, max) = (arr.min, arr.max)
  print(arr.diff(Array(max)).map(_.toLong).sum + " " + arr.diff(Array(min)).map(_.toLong).sum)
}
