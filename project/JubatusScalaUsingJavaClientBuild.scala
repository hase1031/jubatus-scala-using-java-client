import sbt._
import sbt.Keys._

object JubatusScalaUsingJavaClientBuild extends Build {

  lazy val jubatusScalaUsingJava = Project(
    id = "jubatus-scala-using-java-client",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Jubatus Scala Using Java Client",
      organization := "com.hase1031",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      externalPom(),
      resolvers ++= Seq(
        "Jubatus Repository for Maven" at "http://download.jubat.us/maven",
        "MessagePack Repository for Maven" at "http://msgpack.org/maven2"
      )
    )
  )
}
