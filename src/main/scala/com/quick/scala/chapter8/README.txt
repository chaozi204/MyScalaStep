章节描述：
  本章主要讲述Scala中的继承，关键字extends,final,override等

Class8_1：扩展类
  1. scala继承和扩展的方式和java一样，使用extends关键字
  2. 在子类中给出超类没有的字段和方法，或者重写超类的方法
  3. 使用final关键字声明的类是不能被扩展的（和java一样）
  4. 使用final关键字声明的字段和方法是不能被重写的（和java一样）
  5. 重写一个非抽象的方法必须使用override修饰符
  6. 使用super关键字调用超类的方法和字段
  7. 可以用同名的val字段重写一个val（或不带参数的def）
  8. def只能重写了另一个def
  9. val只能重写另一val或不带参数的def
  10. var只能重写另一个抽象的var（只有超类是抽象的var才可以重写）

Class8_2：类型检查和转换
  1. 测试某个对象是否属于某个给定的类，可以使用isInstanceOf方法，测试成功，可以使用asInstanceOf方法将引用转换为子类的引用
    p.isInstanceOf[Employee]
    //如果p是Employee类或子类的实例，则返回true
    //如果p是null，则返回false

  2. val s=p.asInstanceOf[Employee]
    //s为Employee的引用实例

  3. 如果要测试p是某个类的实例，可以使用classOf方法，也可以使用模式匹配的方法
    if(p.getClass == classOf[Employee])

    #模式匹配方法
    p match {
      case s:Employee => ..
      case _ => ...
    }

Class8_3：超类的构造
  1. 子类的辅助构造器不可能直接调用超类的构造器
  2. 只有子类的主构造器才能调用超类的构造器
  3. 在scala的构造器中，你不能调用super(params)的方式
  4. scala 类可以扩展java类，它的主构造器必须调用Java超类的某一个构造方法
    class Square(x:Int,y:Int,width:Int) extends java.awt.Rectangle(x,y,width,
    width)

Class8_4：抽象类、抽象字段
  1. scala中，可以用abstract关键字来标记不能被实例化的类，这种类里面通常有几个方法没有被完整定义
  2. 在子类中重写超类的抽象方法时，不需要使用override关键字
  3. 如果一个类中至少存在一个方法是抽象方法，则该类必须声明为abstract

  4. 抽象字段就是一个没有初始值的字段（具体的子类必须提供具体的字段）

Class8_5：Scala继承层级
  1. scala中所有其他类都是AnyRef的子类，相等于java中的Object
  2. Scala中的基本类型，Int，Double，Unit等，都扩展自AnyVal类
  3. AnyRef和AnyVal都扩展自Any类，定了isInstanceOf,asInstanceOf等方法
  4. Null类型的唯一实例是null，可以将null赋值给任意的AnyRef子类，但是不能赋值给AnyVal子类
  5. 判断两个实例是否相等是，通常使用 == ，该方法会做null检查，并调用equals方法