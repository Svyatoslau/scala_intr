package lectures.week1basics

object Expressions extends App{
  val aVal = 1 + 2 * 3
  println(1 + 2 * 3)

  val aCondition = true

  val ifExpressionValue = if (aCondition) "True Condition"
  else "False Condition"
  println(ifExpressionValue)

  // Если проводить параллели с другими языками
  // программирования - Unit можно ассоциировать с Void.
  val someVal = println("I just want to print")
  println(someVal)

  // Блок кода также является выражением, результат(и тип)
  // которого равен результату(и типу) последнего описанного
  // внутри блока кода выражения.
  val aCodeBclock ={
    val someVal = 1
    val y  = 2
    if (someVal + y > 1) true else false
  }
  println(aCodeBclock)

}
