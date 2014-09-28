package com.quick.scala.chapter6

/**
 * <h2> apply 方法 </h2>
 * 1. 通常情况下，我们会定义和使用对象(object)的 apply 方法
 * 2. apply 方法的调用方式是： Object(参数1,..,参数n)
 */
object Clsss6_4 extends App{

  //例如，我们调用Array对象的apply方法，来创建数组
  val apply_test = Array[String]("I","call","Array","Object","apply function")

  /*
   * 注意下面的这个调用
   */
  //产生一个整型数组，数组长度为1，内容为100，调用的就是Array 的 apply方法
  val test1 = Array(100)

  //产生一个100长度的数组，默认的每个原始初始化为null
  //等价与 new Array[Nothing](100)
  val test2 = new Array(100)

  val testA = A(100,25*1000)
  testA.show()
}

/**
 * 1. class A private 中 private 表示将主构造器定义为私有的
 * 2. class A 需要通过辅助构造器完成实例化（如果存在辅助构造器）或通过伴生对象A完成实例化
 */
class A private (val id:Int,initialBalance:Double){
  private var balance = initialBalance

  def show(){
    println("id = "+this.id)
    println("balance = "+this.balance)
  }
}

/**
 * 通过伴生对象来对外提供对象生成接口（伴生对象可以访问伴生类的私有域）
 */
object A {
  def apply(id:Int,initialBalance:Double) = {
    println("现在只有A的伴生对象可以实例化伴生类A了")
    new A(id,initialBalance)
  }
}
