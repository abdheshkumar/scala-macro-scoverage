package com.abtechsoft

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.collection.immutable.Seq
import scala.meta._

@compileTimeOnly("enable macro paradise to expand @mappable macro annotations")
class mappable extends StaticAnnotation {
  inline def apply(defn: Any): Any = meta {
    val q"..$mods class $tName (..$params) extends $template" = defn

    val keyValues: Seq[Term] = params.map { param =>
      val memberName = Term.Name(param.name.value)
      q"${param.name.value} -> $memberName"
    }

    val res = q"""
      ..$mods class $tName(..$params) {
        def toMap(): Map[String, Any] = Map[String, Any](..$keyValues)
      }
    """

    println("============== result ==============")
    println(res)
    println("====================================")
    res
  }
}