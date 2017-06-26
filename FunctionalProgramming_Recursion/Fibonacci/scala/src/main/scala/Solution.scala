import scala.io.StdIn
import java.io.PrintWriter
import scala.annotation.tailrec

object Solution {

  def fibonacci(x:Int):Int = {

    // Fill Up this function body
    // You can add another function as well, if required
    @annotation.tailrec
    def go(n : Int, acc1 : Int, acc2 : Int) : Int  = n match {
      case 1 => 0
      case 2 => acc2
      case x => go(x - 1, acc2, acc1 + acc2)
    }

    go(x, 0, 1)
  }

  def main(args: Array[String]) {
    /** This will handle the input and output**/
    println(fibonacci(readInt()))

  }
}
