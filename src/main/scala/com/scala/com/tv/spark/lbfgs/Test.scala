package com.scala.com.tv.spark.lbfgs

import com.tv.spark.sample.LocalPi.pr
/**
 * Created on 9/12/14.
 */
object Test extends App{
//  for(x<- 1 to 10 ; j <- 2 until 10 if x%2==0 ; if j%2==0;if j!=x )
//    println(x+","+j)

//  for (i <- 1 to 3;from=4-i;j<-from to 3)
//    println(i+","+j)
  var sum = 1l
  for( c <- "Hello"){
    sum *= c.toInt
  }

  println(sum)
  println("Hello".map(_.toLong).reduce(_*_))
}