package duh.models

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.MongoDBObject

object MongoDBStorage {

  val mongoClient = MongoClient("localhost", 27017)
  val db = mongoClient("scalatra_test")
  val accounts = db("accounts")

  def count = accounts.find.size

  def create(key: String, descritpion: String) = {
    val t: Tuple2[String, String] = "key" -> "oi"

    val tuple = MongoDBObject(
      "key" -> key,
      "description" -> descritpion)

    accounts.insert(tuple)
  }

}