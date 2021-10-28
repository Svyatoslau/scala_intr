package exercises

class GenericList {

}

abstract class LogList[+A] {
  def last: A
  def previous: LogList[A]
  def isEmpty: Boolean
  def all: String
  def add[B >: A](msq: B): LogList[B]
}

class Log[A](head: A, tail: LogList[A]) extends LogList[A] {
  override def last: A = head

  override def previous: LogList[A] = tail

  override def isEmpty: Boolean = false

  override def all: String = {
    def loop(logList: LogList[A] = this, acc: String = ""): String ={
      if (logList.isEmpty) acc
      else loop(logList.previous, s"$acc ${logList.last}")
    }
    loop().substring(1)
  }

  override def add[B >: A](msq: B): LogList[B] = new Log(msq,this)


}

object Empty extends LogList[Nothing] {
  override def last: Nothing = throw new NoSuchElementException

  override def previous: LogList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def all: String = ""

  override def add[Nothing](msq: Nothing): LogList[Nothing] = new Log(msq, Empty)
}