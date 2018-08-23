package com.abtechsoft

import org.scalatest._

object TestEntities {

  @mappable
  case class SimpleCaseClass(i: Int, s: String)

}

class MappableSpec extends WordSpec with Matchers {

  import TestEntities._

 /* @ResolveResourceIds
  def test(a :SimpleCaseClass, id: Option[Long]) = {}*/

  "simple case class" should {
    "deserialise to map" in {

      val testInstance = SimpleCaseClass(i = 42, s = "something")
      testInstance.toMap shouldBe Map("i" -> 42, "s" -> "something")
    }
  }

}
