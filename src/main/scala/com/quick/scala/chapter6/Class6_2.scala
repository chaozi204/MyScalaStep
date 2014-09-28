package com.quick.scala.chapter6

/**
 * <h2> 伴生对象：</h2>
 *  Java 和 C++ 中的既有实例方法又有静态方法的类，在Scala中，通过类和类的伴生对象来实现的
 *  1. 定义中 object Accounts 就是 class Accounts 的伴生对象
 *  2. 类(class) 和 它的伴生对象可以互相访问私有方法
 *  3. 类(class) 和 它的伴生对象必须存在同一个源文件中
 */
object Class6_2 {

  def main(args:Array[String]){
    /*
     * 伴生对象访问 class的私有变量例子。
     * 1.private 变量会生成private的Scala 的 get 和 set 方法
     */
    Accounts.prPrivateField()
  }
}

