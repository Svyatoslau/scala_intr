package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App{
  var i = 0
  val whileVal = while (i < 3) {
    println("hello")
    i += 1
  }

  def factorial(n: Int): Int ={
    if (n<=0) 1
    else n * factorial(n-1)
  }
  val t= System.nanoTime()
  println(factorial(12))
  println(t-System.nanoTime())


  def factorialWithTailRecursion(n: Int): Int ={
    @tailrec
    def loop(x: Int, accumulator: Int=1): Int = {
      if (x <= 1) accumulator
      else loop(x-1, x * accumulator)
    }
    loop(n)
  }
  val k= System.nanoTime()
  println(factorialWithTailRecursion(12))
  println(k-System.nanoTime())

  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String ={
      if ( i<= 1) acc
      else loop(i-1, s"$word $acc")
    }

    loop(n)
  }

  def powerOfTwo(n: Int): BigInt ={
    @tailrec
    def loop(x: Int, acc: BigInt = 1): BigInt={
      if (x <= 0) acc
      else loop(x-1, acc*2)
    }

    loop(n)
  }

  println(powerOfTwo(33))

  def incNum(x: Int, y: Int, n: Int): String = {
    @tailrec
    def loop(i:Int = n, acc: Int = x): String = {
      if (i <= 0){
        @tailrec
        def loop2(k: Int = acc.toString.length, accum: String = acc.toString): String ={
          if (k <= 1) s"$accum is the result"
          else loop2(k-1, s"$accum ${acc.toString}")
        }

        loop2()
      }
      else loop(i-1, acc+y)
    }

    loop()
  }

  println(incNum(10,500,5))
  val input: String = "I like     Scala"
  println(input.split(" ")(input.split(" ").length-2).isEmpty)
  println(input.split(" ").length)
  def reverseWithoutSpace(str: String): String ={
    @tailrec
    def loop(x: Int = str.split(" ").length, acc: String = ""): String = {
      if (x <= 0) acc
      else loop(x -1, {
        if (!str.split(" ")(x-1).isEmpty) s"$acc ${str.split(" ")(x-1)}"
        else acc
      })
    }

    loop().substring(1)
  }

  println(reverseWithoutSpace(input))
















}
