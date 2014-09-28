package com.tv.spark.sample

import org.apache.spark._
import org.apache.spark.SparkContext._
/**
 * Created by fengchao on 7/14/14.
 */
object ScalaWordCount {

  def main(args:Array[String]) {
    // the first args is the file path and name string
    val fileName = args(0)
    val sparkConf = new SparkConf().setAppName("fengchao_test")
    val ctx = new SparkContext(sparkConf)
    val file = ctx.textFile(fileName)

    val counts = file.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_ + _)

    counts.saveAsTextFile(args(1))

  }
  def hello(){

  }
}
