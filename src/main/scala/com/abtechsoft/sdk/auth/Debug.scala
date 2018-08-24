package com.abtechsoft.sdk.auth

import scala.annotation.compileTimeOnly
import scala.meta._

@compileTimeOnly("enable macro paradise to expand @Debug macro annotations")
class Debug extends scala.annotation.StaticAnnotation {
  inline def apply(defn: Any): Any = meta {
    defn match {
      case defn: Defn.Def =>
        val printlnStatements = defn.paramss.flatten.map { param =>
          q"""println(
                ${param.name.syntax} + ": " +
                ${Term.Name(param.name.value)})"""
        }
        val body: Term =
          q"""
          { ..$printlnStatements }
          val start = _root_.java.lang.System.currentTimeMillis()
          val result = ${defn.body}
          val elapsed = _root_.java.lang.System.currentTimeMillis() - start
          println("Method " + ${defn.name.syntax} + " ran in " + elapsed + "ms")
          result
          """
        defn.copy(body = body)
      case _ =>
        abort("@Debug most annotate a def")
    }
  }
}
