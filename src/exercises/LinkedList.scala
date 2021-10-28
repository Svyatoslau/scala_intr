package exercises

object ff extends App{
  println(new Log("m1", new Log("m2", new Log("m3", Empty))).all)

  abstract class LogList {
    def last: String
    def previous: LogList
    def isEmpty: Boolean
    def all: String
    def add(msq: String): LogList
  }

  class Log(head: String, tail: LogList) extends LogList {
    override def last: String = head

    override def previous: LogList = tail

    override def isEmpty: Boolean = false

    override def all: String = {
      def loop(logList: LogList = this, acc: String = ""): String ={
        if (logList.isEmpty) acc
        else loop(logList.previous, s"$acc ${logList.last}")
      }
      loop().substring(1)
    }

    override def add(msq: String): LogList = new Log(msq,this)


  }

  object Empty extends LogList {
    override def last: String = throw new NoSuchElementException

    override def previous: LogList = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def all: String = ""

    override def add(msq: String): LogList = new Log(msq, Empty)
  }
}




