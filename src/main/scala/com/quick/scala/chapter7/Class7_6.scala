package com.quick.scala.chapter7

class Class7_6 {
  private[chapter7] val x = 100
}

object Test1 {
  def main(args:Array[String]){
    val test1 = new Class7_6()

    /**
     * 1.如果没有定义中的private[chapter7]，即使在同包下，也不能访问Class7_6的x属性
     * 这相当于将x的属性的可见性增大了
     */
    println(test1.x)
  }
}

package child{
  object Test2 {
    def main(args:Array[String]){
      val test2 = new Class7_6()

      /**
       * 1. 子包下，我也有权利访问哦
       */
      println(test2.x)
    }
  }
}

