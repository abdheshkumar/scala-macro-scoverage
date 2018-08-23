package com.abtechsoft.model

import com.abtechsoft.data.SimpleCaseClass
import com.abtechsoft.sdk.auth.Debug

object HelloTest {
  @Debug
  def test(a: SimpleCaseClass): SimpleCaseClass = {
    if (a.i > 10) a
    else a.copy(s = a.s + "He")
  }
}
