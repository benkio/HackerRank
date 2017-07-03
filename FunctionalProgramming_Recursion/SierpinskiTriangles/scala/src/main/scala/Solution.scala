import scala.io.StdIn
import java.io.PrintWriter

object Solution extends App {

  val canvasHeight = 32
  val canvasWidth  = 63

  var canvas : Array[Array[Boolean]]= Array.fill(canvasHeight, canvasWidth)(false)
  val startingPoint = Point(0, canvasWidth/2)

  case class Point(x : Int, y: Int)
  case class Triangle(startingPoint : Point, height : Int)


  def printCanvas(c : Array[Array[Boolean]]) : Unit = c.foreach(r => println(r.map(b => if (b) "1" else "_").mkString))
  def computeTriangle(c : Array[Array[Boolean]], fullT: Triangle, elem : Boolean) : Array[Array[Boolean]] = {
    for {
      r <- fullT.startingPoint.x until (fullT.startingPoint.x + fullT.height)
      col <- (fullT.startingPoint.y - (r % fullT.height)) to (fullT.startingPoint.y + (r % fullT.height))
    } {
      c(r)(col) = elem
    }
    c
  }

  def getNextTriangle(newC : Array[Array[Boolean]], th: Int) : List[Triangle] = {
    val (lastLine : Array[(Boolean, Int)], index : Int) =
      newC
        .zipWithIndex
        .map{ case (l, r) => (l.zipWithIndex, r) }
        .filter(t => t._1.exists(x => x._1 == true)).last
    val lastLineFiltered =
      lastLine
        .dropWhile(t => t._1 == false)
        .reverse.dropWhile(x => x._1 == false).reverse
    val newTrianglesStartingPoints = lastLineFiltered
      .filter(
        x => {
          val i = lastLineFiltered.indexOf(x)
          if (i == 0 || i == (lastLineFiltered.length - 1)) true
          else
            (lastLine(x._2 - 1)._1 == false && lastLine(x._2 + 1)._1 == true && x._1 == false) ||
            (lastLine(x._2 - 1)._1 == true && lastLine(x._2 + 1)._1 == false && x._1 == false)
        })
    val newTriangles =
      if (newTrianglesStartingPoints.length == 1)
        newTrianglesStartingPoints
          .flatMap(t => List(Triangle(Point(index + 1, t._2 - 1), th), Triangle(Point(index + 1, t._2 + 1), th)))
      else newTrianglesStartingPoints.map(
        t => {
          val i = lastLineFiltered.indexOf(t)
          i match {
            case 0 => Triangle(Point(index + 1, t._2 - 1), th)
            case x if (i == (lastLineFiltered.length - 1)) => Triangle(Point(index + 1, t._2 + 1), th)
            case _ => Triangle(Point(index + 1, t._2), th)
          }
        })
    newTriangles.toList
  }
  def drawTriangles(n: Int) : Array[Array[Boolean]] = {
    //Draw the N'th iteration of the fractal as described
    // in the problem statement
    def go(n : Int, i : Int,  c : Array[Array[Boolean]], triangles : List[Triangle], th : Int) : Array[Array[Boolean]] = i match {
      case x if (x >= Math.pow(2,n)) => c
      case 0 => {
        val newC = computeTriangle(c, triangles.head, true)
        val newTriangles = getNextTriangle(newC, th)
        go(n, i + 1, newC, newTriangles, th)
      }
      case x => {
        val newC = triangles.foldLeft(c)(
          (c, tr) => {
            val nc = computeTriangle(c, tr, true)
            nc
          })
        val newTriangles = getNextTriangle(newC, th)
        go(n, i + 1, newC, newTriangles, th)
      }
    }

    // Compute the height
    val triangleHeight = canvasHeight/(if (n == 0) 1 else math.pow(2, n).toInt)

    go(n, 0, canvas, List(Triangle(startingPoint, triangleHeight)), triangleHeight)
  }

  printCanvas(drawTriangles(readInt()))

}
