import scala.io.StdIn
import java.io.PrintWriter

object Solution extends App {

  val string1 = readLine();
  val string2 = readLine();
  //  val result = string1.zip(string2).foldLeft("")((s, t) => s :+ t._1 :+ t._2)
  val result = union(string1.toList, string2.toList)
  print(result.mkString)

  def union(s1 : List[Char], s2: List[Char]) : List[Char] =
    if (s1.isEmpty) Nil
    else s1.head :: s2.head :: union(s1.tail, s2.tail)
  
}
