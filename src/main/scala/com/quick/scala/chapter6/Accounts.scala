package com.quick.scala.chapter6

class Accounts {
  /*
   * 伴生对象虽然可以在class中被访问，单并不在class的作用域中
   * 所以调用时需要使用 [伴生对象名.方法名] 或 [伴生对象名.域名的形式]
   */
  val id = Accounts.newUniqueNumber()


  private var balance = 0.0

  def deposit(amount:Double){
    balance += amount
  }
}

/**
 * Scala 没有 Java 中的静态方法和静态字段，我们可以使用 object 这个语法结果来达到同样的目的。
 * object 定义了某个类的单个实例，包含了我们想要的静态特性
 *
 * 1. object 定义的对象的构造器 在该对象第一次被调用时调用
 * 2. 如果一个object定义的对象未被调用过或使用过，那么它的构造器不会被执行
 * 3. 对象(object)不能提供构造器参数，对象本质上可以拥有类的所有特性（除了构造器）
 * 4. Scala中常用对象(object)来实现
 *    1) 通常作为存放工具函数和常量的地方
 *    2) 高效地共享单个不可变实例
 *    3) 需要用单个实例来协调某个服务时(参考单例模式)
 */
object Accounts {
  private var lastNumber = 0

  def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }

  def prPrivateField(){
    println("I can access your private filed [ balance="+new Accounts()
      .balance+"]")
  }

  def main(args:Array[String]){
    /*
     * 1. 当应用程序中需要一个新的账号ID时，就可以直接调用了，而不需要先new Accounts对象
     * 2. 第一次被调用时也就完成了构造器的调用，即对象初始化完成
     */
    val newId = Accounts.newUniqueNumber()
    println("A new Id is = "+newId)
  }
}
