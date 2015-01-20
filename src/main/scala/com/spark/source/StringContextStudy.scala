package com.spark.source

class A {
  private  var a = "0"
}

object  A {
  def main(args:Array[String]){
    println("x")
  }

  implicit object You extends A{

  }
}


