package lectures.week1basics

object Functions extends App{
  def aPerson(name: String, surname: String): Unit = println(s"$name $surname")
  aPerson("John", "Smith")

  def aParameterlessFunction(): Unit = println("Function with no parameters")

  aParameterlessFunction()

  def aFunctionWithDefaultParametr(x: Int, y: String ="Defult Parameter"): String ={
    s"x = $x and y = $y"
  }
  println(aFunctionWithDefaultParametr(1))

  // Вызов по занчению и имени
  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }
  // вызов по имение берёт переменную из ссылки на неё в момент её испоьзования
  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  // вложенные функции
  def aBossFuction(): String = {
    def aHelperFunction(): String ="I'm here to help"
    aHelperFunction()
  }
  println(aBossFuction())
}
