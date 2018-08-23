package com.abtechsoft.sdk.auth

import scala.collection.immutable
import scala.meta._

// $COVERAGE-OFF$ScalaJS + coverage = fails with NoClassDef exceptions
object ResolveResourceIdsImpl {

  def updatedBody(params: immutable.Seq[immutable.Seq[Term.Param]]): List[Stat] = {
    params.flatten.foldLeft(List.empty[Stat])((additions, param) => {
      param.mods.foldLeft(additions)((additions, mod) => {
        mod.children match {
          case
            Term.Apply(Term.ApplyType(Ctor.Ref.Name("ResourceIdExtract"), tagrs), (select@Term.Select(_, field)) :: Nil) :: Nil => {
            q"implicit lazy val ${Pat.Var.Term(Term.Name("implicitIdFor_" + tagrs.head.toString().replace('.', '_')))} = ngage.sdk.api.auth.ResourceId[${tagrs.head}](scala.collection.immutable.Set(${Term.Select(Term.Name(param.name.toString()), field)}).collect({ case x:String if x.trim.nonEmpty => x.trim}))" :: additions
          }
          case
            Term.Apply(Term.ApplyType(Ctor.Ref.Name("ResourceIdsExtract"), tagrs), (select@Term.Select(_, field)) :: Nil) :: Nil => {
            q"implicit lazy val ${Pat.Var.Term(Term.Name("implicitIdFor" + tagrs.head.toString().replace('.', '_')))} = ngage.sdk.api.auth.ResourceId[${tagrs.head}](${Term.Select(Term.Name(param.name.toString()), field)}.collect({ case x:String if x.trim.nonEmpty => x.trim}))" :: additions
          }
          case
            Term.ApplyType(Ctor.Ref.Name("ResourceIdFor"), tagrs) :: Nil => {
            q"implicit lazy val ${Pat.Var.Term(Term.Name("implicitIdFor" + tagrs.head.toString().replace('.', '_')))} = ngage.sdk.api.auth.ResourceId[${tagrs.head}](scala.collection.immutable.Set(${Term.Name(param.name.toString())}).collect({ case x:String if x.trim.nonEmpty => x.trim}))" :: additions
          }
          case
            Term.ApplyType(Ctor.Ref.Name("ResourceIdsFor"), tagrs) :: Nil => {
            q"implicit lazy val ${Pat.Var.Term(Term.Name("implicitIdFor" + tagrs.head.toString().replace('.', '_')))} = ngage.sdk.api.auth.ResourceId[${tagrs.head}](${Term.Name(param.name.toString())}.collect({ case x:String if x.trim.nonEmpty => x.trim}))" :: additions
          }
          case _ => additions
        }
      })
    })
  }

}
// $COVERAGE-ON$