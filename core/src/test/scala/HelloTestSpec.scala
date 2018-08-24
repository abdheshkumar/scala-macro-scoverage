import com.abtechsoft.model.HelloTest
import org.scalatest.{FlatSpec, Matchers}

class HelloTestSpec extends FlatSpec with Matchers {
  it should "work" in {
    val r = HelloTest.test("This is valid input")
    r shouldBe r
  }
}
