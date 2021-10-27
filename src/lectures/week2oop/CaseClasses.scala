package lectures.week2oop

object CaseClasses extends App {
  // Класс образец
  case class Person(name: String, occupation: String)

  //Параметры класса по умолчанию являются val полями.
  val bob = new Person("Bob", "Developer")
  println(bob.name)
  // в обычных классах доступа не будет
  // Информация сразу выводится в понятном виде
  println(bob)

  // Доступен метод equals
  // специально для них метода equals, представляющего content level equality
  // и позволяющего производить сравнение по структуре, а не по ссылкам.

  val bobsDouble = new Person("Bob", "Developer")

  println(bob == bobsDouble)
  // Обычный класс сравнил бы по ссылкам и выдал бы false

  // Доступен метод copy
  // Метод позволяет как полностью скопировать экземпляр класса,
  // так и скопировать с измененными аргументами конструктора.
  val anotherBob = bob.copy()
  println(bob) // Person(Bob,Developer)
  println(anotherBob) // Person(Bob,Developer)

  val bobsTwin = bob.copy( "John")
  println(bobsTwin) // Person(John,Developer)

  // Любой case класс имеет объект-компаньон
  // В таком объекте-компаньоне всегда присутствует метод apply.
  // Которым можно воспользоваться и сделать так:
  val alice = Person("Alice", "Engineer") // метод apply в действии
  // тоесть без new
  object Person{
    def apply(instr: String): Person = Person("fdfs",instr)
  }

}
