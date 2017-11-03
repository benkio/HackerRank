import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  def compute(word1 : String, word2 : String) = {

    val prefix = word1
      .zip(word2)
      .takeWhile(Function.tupled(_ == _))
      .map(_._1)
      .mkString

    val postfix1 = word1.drop(prefix.length)
    val postfix2 = word2.drop(prefix.length)

    println(prefix.length + " " + prefix)
    println(postfix1.length + " " + postfix1)
    println(postfix2.length + " " + postfix2)
  }

  compute(readLine(), readLine())
}
