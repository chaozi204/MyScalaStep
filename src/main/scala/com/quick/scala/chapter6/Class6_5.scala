package com.quick.scala.chapter6

/**
 * <h2> 枚举 </h2>
 * 1. Scala 中并没有定义枚举的类型
 * 2. Scala 提供了一个工具类 Enumeration 可以用以产生枚举
 */
object Class6_5 {
  def main(args: Array[String]) {
    //调用枚举的方式
    println(TrafficLightColor.Red + "   " + TrafficLightColor.Green)

    //遍历枚举的方式,这里x为Value的实例
    for (x <- TrafficLightColor.values) {
      println(x.id + "  "+ x)
    }

    //通过Id和名称来定位枚举的值
    println( TrafficLightColor2(11) )
    println( TrafficLightColor2.withName("go") )
  }
}

object TrafficLightColor extends Enumeration {

  //第一种调用方法调用Value的apply方法，参数3个枚举值
  val Red, Yellow, Green = Value;
}

/**
 * 1. 继承Enumeration产生的枚举类型是 TrafficLightColor.Value 不是TrafficLightColor
 * 2. TrafficLightColor 只是握有这些值的对象
 * 3. 我们可以通过增加别名的方式来更好看一些枚举的类型(意义不是很大)
 */
object TrafficLightColor2 extends Enumeration {
  // 定义后，枚举的类型变为了TrafficLightColor.TrafficLightColor
  type TrafficLightColor = Value

  //调用方式2
  val Red = Value(0, "stop") //明文定义名称为 stop

  //默认名称为字段名
  val Yellow = Value(10) //默认的名称为Yellow

  //如果不指定ID,则默认是在前一个枚举值的基础上加一，默认从0开始
  val Greed = Value("go") //默认的id为11，紧接着上面的值
}
