package com.quick.scala.chapter8

object Class8_4 {

}

/**
 * 用abstract关键字声明一个不能被实例化的抽象类
 * 1. scala中，不需要对抽象方法使用abstract关键字，只要省去方法体，即为抽象方法
 * 2. 如果一个类中至少存在一个方法是抽象方法，则该类必须声明为abstract
 */
abstract class Person2(val name:String){
  // 没有初始化，这是个带有抽象的getter方法的抽象字段
  val uid:Int

  //带有抽象的getter和setter方法的抽象字段
  var sex: String

  //声明一个没有方法体的抽象方法
  def id:Int

}

class Employee2(name:String) extends Person2(name){
  //在子类中重写超类的抽象方法时，不需要使用override关键字
  def id = name.hashCode

  //具体的子类必须提供具体的字段
  //子类中重写超类的抽象字段时同重写抽象方法一样，不需要override关键字
  var sex = "male"
  val uid = 1234323
}