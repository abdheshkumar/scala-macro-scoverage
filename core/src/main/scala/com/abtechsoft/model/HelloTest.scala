package com.abtechsoft.model

import com.abtechsoft.sdk.auth.Debug

object HelloTest {
  @Debug
  def test(a: String): String = {
    if (a.length > 10) a
    else "Invalid"
  }
}
