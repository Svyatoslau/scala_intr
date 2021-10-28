package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {
  val product = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 * v2
  }

  println(product(4, 5))

  // Анонимные функции или лямбда-функции
  val product1 = (x: Int, y: Int) => x * y
  println(product1(6, 7))

  val product2: (Int, Int) => Double = (x, y) => x * y
  println(product2(5, 2))

  val product3: (Int, Int) => Int = _ * _
  println(product3(7, 5))

  val strlen = (x: String) => x.length

  // Функции высщего порядка (High Order Functions)
  // Под функциями высшего порядка понимают такие функции, которые на вход
  // получают другую функцию или же, как результат, возвращают функцию
  val increment = (x: Int) => x+1
  println(nTimes(increment, 0, 3))

  // Каррированные функции (Currying Functions)
  def add(x: Int)(y: Int) = x + y

  println(add(1)(2))

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n-1)(f(x))
  }
  println(curryingNTimes(increment, 3))
  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  println(someFunc(1)(7))
 }

@tailrec
def nTimes(f: Int => Int, x: Int, n: Int): Int = {
  if (n <= 0) x
  else nTimes(f, f(x), n-1)
}


