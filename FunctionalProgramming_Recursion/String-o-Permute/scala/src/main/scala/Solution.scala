import scala.io.StdIn
import java.io.PrintWriter

object Solution extends App {

    val testCasesNumber = readInt()
    val inputList = (0 until testCasesNumber)
      .map(_ => readLine()
             .sliding(2, 2)
             .toList
             .map(_.reverse)
             .mkString)
    inputList.foreach(println(_))
}
