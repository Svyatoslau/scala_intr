package lectures.week2oop

object Inheritance extends App{
  class Person(name: String, age: Int){
    val gender ="n/a"

    def greet: String = s"Hello"
    def this() = this("UnknownPerson", 0)
  }

  sealed class Student(name: String, age: Int, id: Int, override val gender: String) extends Person{
    override def greet: String = s"${super.greet}, $name"
  }

  val student = new Student("James", 24, 1, "m")
  println(student.greet)
  println(student.gender)

  val aPerson: Person = new Student("Alice",24,1,"f")
  class Pizza private{
    override def toString = "This is pizza"
  }

  object Pizza {
    val pizza = new Pizza
    def getInstance: Pizza = {
      pizza
    }
  }

  val pizza = Pizza.getInstance
  println(pizza)

  // абстрактный класс
  abstract class BaseDataSource(dataSourceName: String) {
    def save: String = {
      s"Save method implemend"
    }

    def delete: String = {
      s"Delete method implemented"
    }

    val user: String
    def connect: String

    class PublicDataSource(ds: String) extends BaseDataSource(ds){
      val user = "publicUser"

      override def connect: String = {
        s"Public Data Source? no password needed"
      }
    }

    // анонимный класс
    val someSource = new BaseDataSource("dfs") {
      override val user: String = "someSourceUser"

      override def connect: String = ???

    }
  }
  // трейты
  // всегда без параметров, как абстрактные классы имеют могут иметь реализацию
  // можно указать несколько трейтов, схоже с interface
  // описывают конкретное поведение для конкретной ситуации
  trait PublicCon{
    def connection: Boolean

  }
}
