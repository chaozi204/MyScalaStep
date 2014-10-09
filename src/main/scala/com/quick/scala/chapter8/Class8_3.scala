package com.quick.scala.chapter8

object Class8_3 extends App{
  val em = new Employee1("Tom",28,10000.0)
  val baby = new NewBaby("New Baby","China.TianJin")
  println(em.pName+"->"+em.pAge+"->"+em.salary)
  println(baby.pName+"->"+baby.pAge+"->"+baby.loc)
}

class Person1(name:String,age:Int){

  val pName = name
  val pAge = age

 def this(name:String){
    this(name,0)
  }

 def this(){
    this("NewBaby",0)
  }
}

/**
 * 调用超类的主构造器
 * @param name
 * @param age
 * @param salary
 */
class Employee1(name:String,age:Int,val salary:Double) extends Person1(name,
  age){
}

/**
 * 调用超类的辅助构造器
 * @param name
 */
class NewBaby(name:String,val loc:String) extends Person1(name){

}
