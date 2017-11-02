import scala.io.StdIn
import java.io.PrintWriter
import collection.mutable._

object Solution extends App {

  val input = readLine()

  println(compress(input.toList, 0, new StringBuilder))

  def compress(input : List[Char], counter : Int, sb : StringBuilder): String = input match {
    case x :: Nil => if (counter == 0) (sb += x).result
                     else (sb ++= counter.toString).result
    case x :: y :: tail if counter == 0 && x == y =>
      compress(y :: tail, counter + 2, sb += x)
    case x :: y :: tail if counter >= 0 && x == y =>
      compress(y :: tail, counter + 1, sb)
    case x :: y :: tail if x != y =>
      if (counter == 0) compress(y :: tail, 0, sb += x)
      else compress(y :: tail, 0, sb ++= counter.toString)
    case _ => sb.result()
  }
}
