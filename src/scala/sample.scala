

import common.{LoggerSettings, PostgresCommon, SparkCommon}
import org.slf4j.LoggerFactory

object sample {

  val logger = LoggerFactory.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {

    try {
      logger.warn("starting execution")
      //LoggerSettings.init_logger()
      //val spark = SparkCommon.createSparkSession()
      val spk = SparkCommon.createSparkSession()



      val pgTable = "source_schema.source_data"
      val dbDataFrame = PostgresCommon.fetchDataFrameFromPostgres(spk, pgTable).get
      dbDataFrame.show(false)
      println(dbDataFrame)
      logger.warn("closing spark session")
    }
    catch {
      case e: Exception =>
        logger.error("error processing DF")
    }







  }
}
