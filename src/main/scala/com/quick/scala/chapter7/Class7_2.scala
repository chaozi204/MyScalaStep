package com{
  package quick{
    package scala{
      package chapter7{

      /**
       * 定义一个简单的类，包路径为com.quick.scala.chapter4
       */
        object Utils {
          def percentOf(value:Double,rate:Double) = value * rate / 100
        }

      /**
       * 在定义一个com.quick.scala.chapter7的子包
       */
        package child {
            class Employee {

              var salary = 100.0

              def giveRaise(rate:Double){
                /*
                 * 这里可以直接调用父包的Utils对象,这是因为在嵌套式包定义中
                 * 父包的名称是在子包中可见的
                 */
                salary += Utils.percentOf(salary,rate)
                println("我可以看见我父包中的类或对象定义哦！！")
              }
            }
        }

      object Class7_2 extends App{
        //我也可以这样调用子包中的名称
        import child.Employee
        val e = new Employee()
        e.giveRaise(100)
        println(e.salary)
      }
      }
    }
  }
}
