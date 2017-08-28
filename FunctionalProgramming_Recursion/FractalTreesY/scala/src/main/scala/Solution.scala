import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  def fractalTreeY(interation : Int) = {

  }

  def printLine(length : Int, middleElem : Char, emptyElem : Char) : String = (1 to length).map(x => if (x == length/2) middleElem else emptyElem ).mkString
  def oneLine(length : Int) : String = printLine(length, '1', '_')
  def emptyLine(length : Int) : String = printLine(length, '_', '_')
}
