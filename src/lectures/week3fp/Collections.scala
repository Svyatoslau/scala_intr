package lectures.week3fp

object Collections extends App {
  // Set ( т.е. без дубликатов или повторяющихся элементов)
  val emptySet: Set[Int] = Set()
  val aSet = Set(10, 20, 30, 40)
  val anotherSet = Set(30, 40, 50, 60)
  // Коллекция элементов одного типа
  // по умолчанию содаётся неизменяемый Set
  // *по умолчанию Scala всегда создаёт неизменяемые коллекции
  println("Set ( т.е. без дубликатов или повторяющихся элементов):")
  println(aSet.isEmpty)
  println(emptySet.isEmpty)

  println(aSet.head)
  println(aSet.tail)

  println(aSet.min)
  println(aSet.max)

  println(aSet.intersect(anotherSet)) // пересечения множеств
  println(aSet & anotherSet)

  println(aSet.++(anotherSet)) // сумма множеств
  println(aSet ++ anotherSet)

  // Seq (т.е. у каждого элемента свой индекс,
  // например - Vector, Range, List, Array)
  val aSequence = Seq(1, 3, 2, 4)
  println()
  println("Seq (т.е. у каждого элемента свой индекс, например - Vector, Range, List, Array: ")
  println(aSequence)

  println(aSequence.length)

  println(aSequence ++ Seq(6, 7, 5))

  println(aSequence.reverse)
  println(aSequence.sorted)

  println(aSequence(1)) // получение элемента по индексу
  println(aSequence.search(3))

  // Map (т.е. пары ключ-значение)
  println()
  println("Map:")
  val aMap: Map[String, Int] = Map()

  val colors: Map[String, String] =
    Map(("black", "#000000"), "blue" -> "#0d1ad1", ("Blue", "#161f96")).withDefaultValue("na")
    // withDefaultValue("na") помогает избежать NoSuchElementExeption

  println(colors)

  println(colors.contains("black")) // способы проверить если ключ в Map
  println(colors("black")) // возращает значения ключа

  println(colors("red")) // т.к. такого ключа нет и у нас установлен дефолтный параметр
  // то вместо NoSuchElementExeption нам выдадит na

  // Добавление новой пары ключ-значений
  val color: (String, String) = "green" -> "#339616"
  val newColors: Map[String, String] =colors + color

  println(newColors)

  // конвертация
  println(colors.toList)
  println(List(("White", "#ffffff"), ("Black","#000000")).toMap)

  // Array

  println()
  println("Array:")
  val anArray: Array[String] = Array("h", "e", "l","l","o",".")

  // в Array можно внести изменения на месте
  anArray(5) = "!" // Синтаксический сахар, полной версией будет
  // anArray.update(5, "!")

  println(anArray.mkString("-")) // make string

  val twoElemets: Array[Boolean] = Array.ofDim[Boolean](5) // создаёт пустой массив нужной размерности
  twoElemets.foreach(println)

  // преобразования типа
  val numbersSeq: Seq[String] = anArray
  println(numbersSeq)

  // Tuple
  // Содержит элементы разных типов
  // Способы создания
  println()
  println("Tuple")
  val aTuple: (Int, String) = (100, "Scala")
  val sameTuple: (Int, String) = Tuple2(100, "Scala") // прямо как Functions2, ...

  println(aTuple)

  // Обращения к элементам
  println(aTuple._1)
  println(aTuple._2)

  // копирование причём при копировании можно заменить элеент
  val copy: (Int, String) = aTuple.copy(_2 = "Python")

  println(copy)
  println(aTuple.swap)

  val aRange: Seq[Int] = 1 until 3
  aRange.foreach(println)

  // можно использовать вместо рекурсии если хотим вывести что-то несколько раз
  (1 to 3).foreach(x => println("Hello"))

  // Range помогает создавать коллекции
  val aRangeToVector: Vector[Int] = (1 to 5).toVector
  println(aRangeToVector)

  // foreach - тот же map, только на вход ему подаются функции,
  // возращающие Unit

  // map, flatMap, filter

  // Смысл map заключается в том,
  // что заданная функция применяется к каждому элементу списка.

  // flatMap очень похож на map, только он преобразует каждый элемент
  // в целый список элементов и выполняет действия уже с ними,
  // а потом результат собирает в одно целое.
  println()
  val fruits = List("apple", "banana")

  val mapResult = fruits.map( _.toUpperCase())
  val flatResult = fruits.flatMap(_.toUpperCase())

  println(mapResult)
  println(flatResult)

  val s = "Hello"
  val newStr: String = s.flatMap(c =>(c + "."))
  println(newStr)

  // map тоже сработает, только вернет уже не строку
  println(s.map(s => s + "."))
  println(s.map(s => s + ".").mkString)

  // скомбинируем элменеты
  val list1 = List(1,2)
  val list2 = List("a", "b")

  val combination =  list1.flatMap(x => list2.map(s=>s+x))
  println(combination)

  // аналогичный код с for
  val forCombination = for {
    n <- list1
    c <- list2
  } yield c + n

  // два способа пройтись по спискам
  // filter помогает отобрать элементы, удовлетворяющие заданным условиям
  list1.filter(_ > 1).flatMap(n => list2.map(c => c+ n))

  val forFilterCombination = for {
    n <- list1 if n > 1
    c <- list2
  } yield c + n

  println(forFilterCombination)
}
