章节描述：
  本章主要讲述Scala的包定义和引用，相对于java来说，Scala更包管理更灵活

Class7_1知识点：
  1. 同一个包名可以定义在不同的多个文件中，也就是我们可以在多个不同的文件中有相同的包定义（见Employee和Manager定义）
  2. 源文件所在的目录和包之间没有强制的关联关系，也就是说源文件中package的定义路径和源文件所在的目录可以不一样(和java不同),
     见Employee文件中，Student类定义
  3. 换个思维想，我们也可以在同一个文件中为多个包贡献内容，就像Employee文件中为2个包定义了类

Class7_2作用域规则：
  1. Scala的包和其他作用域一样的支持嵌套，支持访问上一层作用域的名称（嵌套式的定义中才有）-- 见Class7_2
  2. Scala的报名是相对的，如在Class7_2中使用的 import child.Employee
      就是使用了相对的包名（这和java绝对包名是不一样的）
  3. 因为相对包名会导致一个瑕疵就是Scala中，错误的相对报名，如scala.collection包，我们直接用时是省去scala的，
     但是如果我在包中定义一个collection包，如果用相对路径时就会导致无法编译问题，可以通过使用绝对包名的方式解决
     val sub = new _root_.scala.collection.mutable.ArrayBuffer[String]
     以_root_开头的包就是要求的绝对路径包名

     另一种做法就是使用串联式包，这里我也建议使用串联式包，毕竟简单而且约束力强

Class7_3串联式包语句（见Class7_3）：
  1. 包语句可以包含一个“串”，或者说路径区段，例如
     package com.layer1.layer2 {
      package people{
        class Person{}
      }
     }
  2.这样的包语句限定了可见性，此时com.layer1下成员在这里就在people内不可见了


Class7_4 文件顶部标记法：
  除了包的嵌套标记法外，也可以在文件顶部使用package语句且不带花括弧的顶部标记法，如
  package com.quick.scala.chapter7
  package child
  等价于 ==
  package com.quick.scala.chapter7{
    package child{ }
  }

Class7_5 包对象：
  1. Scala中包内可以包含包，对象，类，特征等，同时也可以包含变化和函数，这就是包对象(package object)的作用
  2. 每个包都可以有一个包对象，定义包目录下,文件名为package.scala，且定义和报名一样的对象（见package.scala）
  3. 幕后，包对象被编译成带有静态方法和字段的JVM类，类名为package.class,位于相应包下

Class7_6 包可见性：
  1. 在Scala中，可以通过增加修饰符达到包的可见性定义，如
    private[quick] 表示在quick包下可见

Class7_7：包，类，属性的import
  1. 引入具体的某个类，如：import java.awk.Color
  2. 引入包下的所有成员： import java.awk._ (这里和java不一样，java是*，而scala是_)
  3. 引入类或对象的所有成员： import java.awk.Color._ (类似java的 import static)

  4. 可以在代码的任何地方声明引入语句，而不限于顶部

  5. 使用选择器（selector)，引入包中的几个成员，如
      import java.awk.{Color,Font} 只引入Color和Font成员

  6. 重命名选取的成员
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.mutable._
    这样JavaHashMap就表示是java.util.HashMap，HashMap对应scala.collection.mutable
    .HashMap

  7. 隐藏成员变量
    import java.util.{HashMap => _ } 隐藏成员变量，也就是让这个成员不可见，在处理冲突的时候比较有用

  8. 每个scala成员隐式引入了 java.lang._ ,scala._ 和 Predef._ ，后面的覆盖前面的引入

