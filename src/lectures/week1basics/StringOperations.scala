package lectures.week1basics

object StringOperations extends App{
  val aString: String = "Hello, world!"

  println(aString.length)
  println(aString.charAt(1))
  println(aString.substring(0, 2))
  println(aString.split(" ").toList)
  println(aString.startsWith("He"))
  println(aString.replace("!",","))
  println(aString.toLowerCase)
  println(aString.toUpperCase)
  println("abcd".reverse)
  println("abcd".take(2))

  val aNumber = "42".toInt
  println(aNumber)
  println(aNumber.getClass)

  println('1' +: "42" :+ '3')
  println('a' +: "bc" :+ 'd')
  println("a" ++ "bc" :++ "d")

  println(1 +: List(2,3))
  println(List(1,2) ++ List(3,4))
  println(List(1,2) +: List(3,4))

  val name = "John \t"

  // s-интерполятор - используется для подставления значения
  // переменной типа String в строку.
  println(s"Hello, $name")

  val surname = "Smith"

  println(s"Hello, ${name + surname}")

  val someString = "This is \n a string"

  println(raw"This is \n a string")

  println(raw"$someString")

  println(name :++ "/catalog")
}
