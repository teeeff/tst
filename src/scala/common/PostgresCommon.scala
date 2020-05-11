package common

import java.util.Properties

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.slf4j.LoggerFactory

object PostgresCommon {
  val logger = LoggerFactory.getLogger(getClass.getName)

  def getPostgresCommonProps()={
    logger.info("setting up postgres connection")
    val pgConnectionProperties = new Properties()
    pgConnectionProperties.put("user", "postgres")
    pgConnectionProperties.put("password", "mysecuredb")
    pgConnectionProperties
  }

  def fetchDataFrameFromPostgres(spark: SparkSession, TableName : String): Option[DataFrame] = {



    try {
      logger.warn("Fetching dataframe from spark session")
      val pgConnectionProperties = getPostgresCommonProps
      val df = spark.read.jdbc("jdbc:postgresql://localhost:5432/source", TableName, pgConnectionProperties)
      Some(df)
    }
    catch {
      case e: Exception =>
        logger.warn("got exception")
        System.exit(2)
        None
    }
  }

}
