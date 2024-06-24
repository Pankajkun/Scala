object GroupCitiesByFirstLetter {
  def main(args: Array[String]): Unit = {

    println("Enter city names separated by commas:")
    val input = scala.io.StdIn.readLine()

    val cities = input.split(",").map(_.trim)

    var cityGroups = Map[Char, List[String]]()

    for (city <- cities) {
      if (city.nonEmpty) {
        val firstChar = city.head.toLower

        cityGroups = cityGroups.updatedWith(firstChar) {
          case Some(existingCities) => Some(city :: existingCities)
          case None => Some(List(city))
        }
      }
    }

    for ((firstChar, cityList) <- cityGroups) {
      println(s"Cities starting with '$firstChar': ${cityList.mkString(", ")}")
    }
  }
}
