import scala.io.StdIn
import java.io.PrintWriter


object Solution extends App {

  val loginAttempt = readInt()

  val attempts = (1 to loginAttempt).map(_ => readLoginAttempt)

  attempts.map(a => checkAttempt(a._1, a._2, List()) match {
                 case None => "WRONG PASSWORD"
                 case Some(x) => x.reduce((s1, s2) => s1 + " " + s2)
               }).foreach(println)

  def readLoginAttempt : (List[String], String) = {
    val numberOfPasswords = readInt()
    val passwords = readLine.split(" ").toList
    val loginAttempt = readLine()
    (passwords.filter(p => loginAttempt.contains(p)), loginAttempt)
  }

  def checkAttempt(passwords : List[String], attempt : String, acc : List[String]) : Option[List[String]] = (attempt, passwords.filter(p => attempt.startsWith(p))) match {
    case (a, _) if a.isEmpty => Some(acc)
    case (a, ps) => checkAttemptPrefixes(passwords, attempt, acc, ps)
  }

  def checkAttemptPrefixes(passwords : List[String], attempt : String, acc : List[String], prefixes : List[String]) : Option[List[String]] =
    if (prefixes.isEmpty) None
    else
      checkAttempt(passwords, attempt.drop(prefixes.head.length), (acc :+ prefixes.head))
        .orElse(checkAttemptPrefixes(passwords, attempt, acc, prefixes.tail))


}
