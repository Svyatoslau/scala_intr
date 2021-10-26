package lectures.week2oop

object ClassesOOP extends App {

  val student  = new Student(1, "Sam")
  println(student.getId("Pam", 2))
  println(student.getId)

  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")

  val a = new Instructor(1,"GLEB","kotov")
  println(a.fullName)
}

class Student(id: Int = 0, val name: String){

  def this(name: String) = this(0,name)
  def this() = this(0,"NoName")


  def getId(name: String, id: Int): String =
    s"${this.name} has ID ${this.id} and $name has ID $id"

  def getId: String = s"gere is $name's ID $id"
}

class Employee(val name: String, var salary: Double) {
  def this() = this("John", 0.0)
}

class Instructor(val id: Int, val name: String, val surname: String){
  def fullName: String =
    s"${name.substring(0,1).toUpperCase() ++: name.toLowerCase().substring(1)} " +
      s"${surname.substring(0,1).toUpperCase() ++: surname.substring(1).toLowerCase()}"
}

class Course(val courseID: Int, val title: String, val releaseYear: String, val instructor: Instructor){
  def getID: Int = (courseID.toString + instructor.id.toString).toInt

  def isTaughtBy(instructor: Instructor): Boolean = instructor == this.instructor

  def copyCourse(newRealeseYear: String): Course = new Course(courseID, title, newRealeseYear, instructor)
}

