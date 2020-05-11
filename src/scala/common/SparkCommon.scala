package common

import java.io.File

import org.apache.spark.sql.SparkSession
import org.slf4j.LoggerFactory

object SparkCommon {

  val logger = LoggerFactory.getLogger(getClass.getName)

  def createSparkSession():SparkSession = {

    logger.warn("Hive config init")
    val warehouseLocation = new File("/Users/tinufarid/Downloads/spark-warehouse").getAbsolutePath


    logger.warn("Spark session builder")
    val spark = SparkSession.builder
      .master("local")
      .appName("Word Count")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .enableHiveSupport()
      .getOrCreate()

    spark

  }



}
