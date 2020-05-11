package common

import org.apache.log4j.{Level, Logger}
import org.slf4j.LoggerFactory

object LoggerSettings {

  val logger = LoggerFactory.getLogger(getClass.getName)

  def init_logger()={

    logger.warn("Setting up log level")
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

  }

}
