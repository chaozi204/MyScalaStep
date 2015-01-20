package study.action.in.scala.chapter2

import java.util.Date

/**
 * Created on 1/19/15.
 * Scala 的原生类型，同Java一致
 */
class PrimitiveType {
  // Int类型的表示方法
  val i1 = 12 // 10 进制表示方式
  val i2 = 014 //8 进制表示（然而其底层仍以10进制表示)
  val i3 = 0xC //16进制表示方式

  // floating-point literal 浮点类型
  // 浮点类型字面量是由数字 <+ 小数点 + 指数部分> (<>表示可选）
  val float1 = 0.1f //scala 默认为double类型,需要f为后缀表示float
  val float2 = .1f //可以如此，但不能如此 1.f

  val double1 = 1.1e10 //带有指数部分
  val double2 = 1.1
  val double3 = 1. //可以如此定义，省去部分信息
  //在Scala中，我们是可以通过小数点来调用方法的，如果利用double3中的定义字面量来调用方法
  // 就会出现意想不到的的问题，
  //系统会将 1.toString 调用整形的1的toString的方法： 结果1
  //系统会将 1. toString 调用double类型的toString的方法：结果 1.0
}

/**
 * 字符字面量
 */
class CharacterLiterals{
  //字符字面量就是在单引号里面的单个字符
  //可以使用Unicode 字符表示，也可以用转义序列表示
  val char1 = 'B'
  val char2 = '\102'

  //也可以将转义字符 \ 和特定的字符常量组合成新的特殊字符，如换行，tab等
  val char3 = '\t'
  val char4 = '\n'
}

/**
 * 字符串字面量
 * 定义：双引号之间的字符序列，可以是可打印的Unicode字符，也可以是转义字符序列
 */
class StringLiterals {
  //Scala中字符串的类型是java.lang.String,而不像其他的类型是Scala包下的类型
  val string1 = "Scala in \"Action\"";
  //Scala中也支持三重引号包括中的多行字符串表示形式
  //三重引号内的字符串可以包含任何字符（除了三重引号外）
  val string2 = """Scala in "Action"
      |for you.
      |hello"""
  //多行字符串变量打印输出会出现空格开头，如果我们不需要这些空格，可以通过调用stripMargin来解决
  val string3 = string2.stripMargin

  //Scala 2.10之后支持字符串插入，如下使用方式
  val string4 = "World"
  val string5 = s"Hello $string4 ,or Hello ${string4}"

  // 不像RichInt等类型的封装，String的封装类是scala.collection.immutable.StringLike(从2.8版本开始）
}

/**
 * Scala 中的XML 字面量表示
 */
class XmlLiteral {
  //Scala自带支持XML格式的字符串，使用方式如下
  val book:scala.xml.Elem = <book>
    <title>Scala in Action</title>
    <author>Nilanjan Raychaudhuri</author>
  </book>

  //我们可以动态想xml元素内插入合法的code，这对于动态生成xml来说，非常有帮助，如
  val message = "I didn't know xml could be so much fun"
  val code = "1"
  //不可如此使用"{code}"，否则只会成为一个字符串，而不会替换为scala code block
  val alert = <alert>
    <message priority={code}>{message}</message>
    <date>{new Date()}</date>
  </alert>
}

object PrimitiveType {
  def main (args: Array[String]) {
    // test1
    val test1:StringLiterals = new StringLiterals();
    println(test1.string2)
    println(test1.string3)
    println(test1.string5)

    //test2
    val test2:XmlLiteral  = new XmlLiteral
    println(test2.alert)
  }
}