package lectures.week2oop

object SyntacticSugar extends App{
  // Инфиксная нотация (Infix notation)
  // Подходит только для методов с одним параметром
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): Boolean = jobName == occupation
    def speaksEnglish: Boolean =true
    def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"
    def unary_! : String = s"$name is not real"

    def apply(): String = s"$name works as a $occupation"
    def unary_+ : Person = new Person(s"${this.name} NoSurname", this.occupation)
  }


  val bob = new Person("Bob", "Developer")
  // Обычный вариант
  println(bob.worksAs("Developer"))

  // Но так как worksAs принимает на вход всего один аргумент, то вызов этого метода
  // мы можем переписать в инфиксной нотации:
  println(bob worksAs "Developer")

  // Операторы
  println(1 + 2) // обычное обращение
  println(1.+(2)) // обращение через точку

  // А еще операторы можно использовать в качестве имени метода.

  val alice = new Person("Alice", "Data Engineer")

  println(bob.&(alice)) // точечная нотация
  println(bob & alice) // инфиксная нотация

  // Префиксная нотация (Prefix notation)
  val x = -1
  val y = 1.unary_-

  // Префикс unary_ подходит только для + - ~ !
  // Оператор с unary_ также можно использовать в качестве имени функции:
  // Теперь вызвать unary_! мы можем тремя способами:
  println(!bob) // префиксная нотация
  println(bob.unary_!) // точечная нотация


  // Метод apply
  // И опять у нас на выбор два способа вызова apply:
  println(bob.apply())
  println(bob())
}
