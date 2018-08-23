import com.abtechsoft.data.SimpleCaseClass
import com.abtechsoft.model.{HelloTest, Util}
import org.scalatest.{FlatSpec, Matchers}

class MappableTest extends FlatSpec with Matchers {
  it should "work" in {
    val r = HelloTest.test(SimpleCaseClass(i = 11, s = "testdsd"))
    r shouldBe r
  }

  it should "also work" in {
    val r = Util.simpleFunction(SimpleCaseClass(i = 10, s = "test"))
    r shouldBe r
    val r0 = Util.anotherSimpleFunction("Hello")
    r0 shouldBe "Hello"
  }

}
