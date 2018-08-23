lazy val root = (project in file("."))
  .settings(
    name := "ngage-macro",
    scalaVersion := "2.12.3",
    organization := "uk.callhandling",
    version := "1.0",
    scalacOptions += "-Xplugin-require:macroparadise"
  )
  .settings(
    addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M10" cross CrossVersion.full),
    libraryDependencies ++= Seq(
      "org.scalameta" %% "scalameta" % "1.8.0",
      "org.scalatest" %% "scalatest" % "3.0.1" % Test
    ))

val core = (project in file("core"))
  .settings(
    name := "core",
    scalaVersion := "2.12.3",
    organization := "uk.callhandling",
    version := "1.0",
    scalacOptions += "-Xplugin-require:macroparadise",
    coverageEnabled := true,
    coverageExcludedFiles := "<macro>",
    coverageOutputXML := false,
    coverageOutputCobertura := false
  )
  .settings(
    addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M10" cross CrossVersion.full),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.1" % Test
    )
  )
  .dependsOn(root)