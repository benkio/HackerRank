import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  def timeConversion(s: String): String =  {
    // Complete this function
    if (s.endsWith("AM")) {
      if (s.startsWith("12")) "00" ++ s.drop(2).dropRight(2)
      else s.dropRight(2)
    }
    else {
      val hh = s.take(2).toInt % 12
      (hh+12).toString ++ s.dropRight(2).drop(2)
    }
  }

  val sc = new java.util.Scanner (System.in);
  var s = sc.next();
  val result = timeConversion(s);
  println(result)


}
