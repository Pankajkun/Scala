object DataTypes {
  def main(args: Array[String]): Unit = {
    val byteNum: Byte = 127

    val intNum: Int = 20

    val shortNum: Short = 32678
    var longNum: Long = 12344536547L

    val FloatingNum: Float = 3.14f
    val double: Double = 3.141595397759837597

    var StringVar: String = "Hello World"

    var charVar: Char = 'a'

    val unitValue: Unit = ()

    println(s"Integer: $intNum")
    println(s"Float: $FloatingNum")
    println(s"String: $StringVar")
    println(s"CharVar: $charVar")
  }

}
