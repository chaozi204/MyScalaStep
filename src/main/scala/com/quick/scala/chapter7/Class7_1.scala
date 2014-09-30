package com.quick.scala.chapter7

import com.quick.scala.chapter7.student.Student

/**
 * 第一章的执行类
 *
 * 顺便看看我的包名定义，是不是对Java程序员来说更熟悉啊
 */
object Class7_1 extends App {
  /*
   * 同包名下，我可以省去前缀访问类，和java一样
   */
  print("look my package name ：")
  println(new Manager().getClass.getPackage)

  /*
   * 我也可以带上前缀访问类，和java一样
   */
  val em = new com.quick.scala.chapter7.Employee()
  println(em.desc())

  /*
   * 也可以通过import 引入的方式
   */
  val stu = new Student()
  println(stu.desc)
}
