package exercises

object LogSystem extends App{

  class Logger(val msqNum: Int = 0) {
    def info : Logger = {
      println("INFO New Message")
      new Logger(msqNum + 1)
    }

    def info(n: Int): Logger = {
      if (n <= 0) this
      else info.info(n-1)
    }

    def print: Unit = println(msqNum)
  }

  val logger = new Logger
  logger.info.info.info.info(6).print
  logger.info.print
}

