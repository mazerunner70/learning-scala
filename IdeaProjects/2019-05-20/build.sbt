name := "2019-05-20"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "com.lihaoyi" %% "fastparse" % "2.1.0"
libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.11.0"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0-M1"

scalacOptions += "-Ypartial-unification"