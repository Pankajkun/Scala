object data_structs {
  def main(args: Array[String]): Unit = {
    val fruits: List[String] = List("apple", "banana", "grape", "oranges")
    //println("First Element: " + fruits.head)
    //println("Last Element: " + fruits.last)

    //val list_1 = List("fruits", "veggies", 281876, List("list", "ke", "andar", "list"))
    //list_1.foreach(println(getClass))

    //list
    var list_1 = 10::20::30::40::Nil
    //println(list_1.getClass)
    import scala.collection.mutable.ListBuffer
    var cities = new ListBuffer[String]()
    cities += "Trivandrum"
    cities += "Kolkata"
    cities.toList
    cities += ("Mumbai", "Pune")


    println(cities.getClass)
  }
}