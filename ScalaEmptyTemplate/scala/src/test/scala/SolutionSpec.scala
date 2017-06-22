import java.io.{PrintStream, ByteArrayOutputStream}

import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}

import scala.io.Source

/**
 * Created by jjst on 11/10/15.
 */
class SolutionSpec extends FlatSpec with Matchers with BeforeAndAfter {

  val defaultOut = System.out
  val defaultIn = System.in

  after {
    System.setOut(defaultOut)
    System.setIn(defaultIn)
  }

  "Output of the solution" should "match the sample output" in {
    val baos = new ByteArrayOutputStream()
    //println(Source.fromInputStream(getClass.getResourceAsStream("/sample.input")).getLines().mkString("\n"))
    System.setOut(new PrintStream(baos))
    Console.withIn(getClass.getResourceAsStream("/sample.input")) {
      Console.withOut(baos) {
        Solution.main(Array.empty)
      }
    }
    val output = baos.toString
    val expectedOutput = Source.fromInputStream(getClass.getResourceAsStream("/sample.output")).mkString

    output shouldBe expectedOutput
  }
}
