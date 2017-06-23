import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var a0 = sc.nextInt();
    var a1 = sc.nextInt();
    var a2 = sc.nextInt();
    var b0 = sc.nextInt();
    var b1 = sc.nextInt();
    var b2 = sc.nextInt();
    val tripletsZipped = List(a0, a1, a2).zip(List(b0, b1, b2))
    val aliceScore = tripletsZipped.map(t => t._1 - t._2).count(s => s > 0)
    val bobScore = tripletsZipped.map(t => t._2 - t._1).count(s => s > 0)
    println(s"$aliceScore $bobScore")
  }

}
