package com.abtechsoft.sdk.auth

import scala.annotation.compileTimeOnly
import scala.meta._

@compileTimeOnly("enable macro paradise to expand @ResolveResourceIds macro annotations")
class ResolveResourceIds extends scala.annotation.StaticAnnotation {
  inline def apply(defn: Any): Any = meta {
    val d = defn /*match {
      case d@Defn.Def(_, _, _, params, _, Term.Block(body)) => {
       /* val newResourceIdExtractors = ResolveResourceIdsImpl.updatedBody(params)

        val newDef = d.copy(body = Term.Block(newResourceIdExtractors ++ body))
        newDef*/
        d
      }
      case d@Defn.Def(_, _, _, params, _, body) => {
       /* val newResourceIdExtractors = ResolveResourceIdsImpl.updatedBody(params)
        val newDef = d.copy(body = Term.Block(newResourceIdExtractors ++ Seq(body)))
        newDef*/
        d
      }
      case d => {
        d
        //abort("@ResolveResourceIds must annotate a method")
      }
    }*/
    println("============== result ==============")
    println(d)
    println("====================================")
    d
  }
}

