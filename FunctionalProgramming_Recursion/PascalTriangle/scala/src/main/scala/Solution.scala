import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  val k = readInt()

  def factorial(n : Int) = if (n == 0 || n == 1) 1 else (1 to n).fold(1)(_ * _)
  def binomialCoefficient(r : Int, c : Int) : Int = (factorial(r))/(factorial(c) * factorial(r-c))
  def pascalTriangle(k : Int) : List[List[Int]] = (0 until k).toList.map(r => (0 to r).toList.map(c => binomialCoefficient(r, c)))

  pascalTriangle(k).map(l => l.mkString(" ")).foreach(println(_))
}
