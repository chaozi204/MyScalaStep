package com.quick.scala.chapter7

object Class7_5{
  def main(args:Array[String]){
    /**
     * 1. 注意defaultName不需要加限定词，因为它位于同一个包下
     * 2. 如果想在其他包也用这个包对象的内容，需要用com.quick.scala.chapter7.defaultName方式访问
     */
    val default = defaultName
  }

}

/**
 * 注意如果想在这里定义包，且不加花括弧是不对的，因为顶部定义法必须再顶部才能其作用
 */
package child{

  object childPackage {
    def main(args:Array[String]){
      /**
       * 1. 子包中也可以直接访问父包对象的属性
       */
      val default1 = defaultName
      println(default1)
     }
    }
}
