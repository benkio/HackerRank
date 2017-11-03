import scala.io.StdIn
import java.io.PrintWriter

object Solution extends App {

  def numberOfWays(X:Int,N:Int):Int = {
    // Compute the answer in this function over here
    // It is fine to define new functions as and where required

    // @annotation.tailRec
    def compute(target : Int,
                power : Int,
                numbers : List[Int],
                acc : Int) : Int = {
      if (target == 0) return acc + 1
      if (numbers.isEmpty) return 0
      else {
        val newTarget = target - Math.pow(numbers.head, power)

        compute(newTarget.toInt, power, numbers.tail, acc ) +
                compute(target, power, numbers.tail, acc)
      }
    }

    val numbers = (1 to X).takeWhile(scala.math.pow(_, N) <= X ).toList
    compute(X, N, numbers, 0)
  }


  println(numberOfWays(readInt(),readInt()))


}
