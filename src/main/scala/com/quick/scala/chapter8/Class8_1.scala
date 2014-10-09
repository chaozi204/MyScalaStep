package com.quick.scala.chapter8

class Person{
  var id = 1
  val name = "default"
}

class Employee extends Person {
  //添加自己的属性
  var company = "sohu"

  //重写val修饰的字段
  override val name = "sohu_em"

  /**
   * 重写一个非抽象的方法一定要用override修饰符
   * （如果是抽象方法，可不使用override修饰符）
   * @return
   */
  override def toString = getClass.getName + "[name=" + name +" ]"

  /**
   * 子类中调用父类的方法和字段，需要使用super关键字
   */
  def toPrint(){
    println(super.toString)
    println(id)
//    像id已经被继承的情况下，就不能再使用super了
//    println(super.id)
  }
}

object Class8_1 {
  def main(args:Array[String]){
    val ee = new Employee();
    ee.toPrint()
  }
}