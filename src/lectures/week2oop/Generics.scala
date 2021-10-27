package lectures.week2oop

object Generics extends App {
  class MyList[A]

  val listOfStrings = new MyList[String]
  val listOfDoubles = new MyList[Double]
  val listOfInts = new MyList[Int]

  def randomItem[A](items: List[A]): A = {
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }

  println(randomItem(List("a","bc","def")))
  println(randomItem(List(1.5, 2.75, 3.8)))

  class Fruit
  class Apple extends  Fruit
  class Banana extends Fruit

  // Инвариатность позволяет нам приводить обобщение одного конкретного типа
  // К обобщение точно такого же типа

  class InvariantList[A]

  val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit]

  // Ковариантность позволяет нам приводить обобщение типа класса наследника
  // К обобщению типа класса предка
  class CovariantList[+A]

  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]

  // Контрвариантность позволяеть приводить обобщение типа класса предка
  // К обобщению класса наследника

  class ContrvariantList[-A]

  val contrvariantList: ContrvariantList[Apple] = new ContrvariantList[Fruit]

  // верхнее ограничение
  class Food[+T <: Fruit]
  val dood: Food[Fruit] = new Food[Banana]

  // нижнее ограничение T >: A
}
