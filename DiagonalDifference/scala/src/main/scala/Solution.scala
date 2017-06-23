import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var a = Array.ofDim[Int](n,n);
    for(a_i <- 0 to n-1) {
      for(a_j <- 0 to n-1){
        a(a_i)(a_j) = sc.nextInt();
      }
    }
    val firstDiagonal = for(i <- 0 until n) yield a(i)(i)
    val secondDiagonal = for(i <- 0 until n; j <- 0 until n if ((i + j) == (n-1))) yield a(i)(j)
    val result = (firstDiagonal.sum - secondDiagonal.sum).abs
    println(result)

}
