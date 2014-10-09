package com.quick.scala.chapter8

object Class8_2 extends App{
  val p = new Employee
  val x = new Person

  //判断p是不是某个类或其子类的实例
  if(p.isInstanceOf[Employee]){
    println("I am instance of Employee")
  }
  if(p.isInstanceOf[Person]){
    val s = p.asInstanceOf[Person]
    println("I am instance of Person")
  }

  //判断p是不是某个类的实例，使用classOf方法
  if(p.getClass == classOf[Employee]){
    println("我就是Employee类的实例:"+classOf[Employee])
  }

  // 利用模式匹配检查类型
 p  match {
   case s:Employee => println("我就是Employee类的实例:"+classOf[Employee])
   case s:Person => println("我就是Person类的实例:"+classOf[Person])
   case _ => println("....")
 }
}
