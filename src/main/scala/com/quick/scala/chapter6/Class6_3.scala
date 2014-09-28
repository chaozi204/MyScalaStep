package com.quick.scala.chapter6
/**
 * <h2> 扩展类或特征的对象 </h2>
 * 1. 对象(object)可以扩展一个类(class) 以及 一个或多个特征(trait)
 * 2. 扩展了类或特征的对象，同时拥有了类和特征的所有特性
 * 3. 扩展的类和特征其本质是扩展了它们的一个实例的特性，见 DoNothingAction
 */
object Class6_3 {
  def main(args:Array[String]){

    println("object 继承了 class 的域 description = ["+DoNothingAction.description+"]")

    println("object 继承了 class 的函数 redo = ["+DoNothingAction.redo()+"]")

    println("object 继承了 class 的函数并重写 undo = ["+DoNothingAction.undo()+"]")
  }
}

abstract class UndoableAction(val description:String){
  def undo():Unit
  def redo()={
    "I am redo"
  }
}
/**
 * 1. 因为object是无参数的构造器，因此在继承有参构造器的class时，需要指定实参（也就
 */
object DoNothingAction extends UndoableAction("Do nothing"){
  override def undo() {
    println("I am undo")
  }
}