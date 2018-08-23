package com.abtechsoft.model

import com.abtechsoft.data.SimpleCaseClass

object Util {
  def simpleFunction(a: SimpleCaseClass): SimpleCaseClass = {
    if (a.i > 10) a
    else a.copy(s = a.s + "He")
  }

  //@ResolveResourceIds
  def anotherSimpleFunction(a: String): String = {
    if (a.nonEmpty) a else a + "Hello"
  }

}
