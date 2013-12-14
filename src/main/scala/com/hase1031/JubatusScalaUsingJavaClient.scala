package com.hase1031

import us.jubat.common.Datum
import us.jubat.recommender.IdWithScore
import us.jubat.recommender.RecommenderClient
import scala.collection.JavaConverters._

object JubatusScalaUsingJavaClientProject extends App {
  val client = new Client
  client.start
}

class Client {
  final val HOST = "127.0.0.1"
  final val PORT = 9199
  final val NAME = ""

  def start {
    val r = new RecommenderClient(HOST, PORT, NAME, 5)

    // user01
    val d1 = new Datum().addNumber("movie_A", 5).addNumber("movie_B", 2)
      .addNumber("movie_C", 3)
    r.updateRow("user01", d1)

    // user02
    val d2 = new Datum().addNumber("movie_A", 2).addNumber("movie_B", 5)
      .addNumber("movie_C", 1)
    r.updateRow("user02", d2)

    // user03
    val d3 = new Datum().addNumber("movie_A", 5).addNumber("movie_B", 1)
      .addNumber("movie_C", 4)
    r.updateRow("user03", d3)

    val rows = r.getAllRows.asScala
    for (id <- rows) {
      val result = r.similarRowFromId(id, 3).asScala
      println(id + " is similar to: ")
      print("  ")
      for (tuple: IdWithScore <- result) {
        print(tuple.id + " (" + tuple.score + "), ")
      }
      println
    }
  }
}