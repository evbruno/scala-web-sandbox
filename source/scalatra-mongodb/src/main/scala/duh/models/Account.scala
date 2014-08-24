package duh.models


case class Account(
  key: String,
  description: String) {
  
  def save {
    Account.create(key, description)
  }
  
}

object Account {

  def count : Int = MongoDBStorage.count

  def create(key: String, descritpion: String) = {
    MongoDBStorage.create(key, descritpion)
  }

}