import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {
  val sc = new java.util.Scanner (System.in);
  var n = sc.nextInt();
  val stair = (1 to n).map(x => (n-x, x))
  stair.foreach(x => printStep(x._1, x._2))

  def printStep(spaces : Int, step: Int) =
    println(" " * spaces + "#" * step)

}
