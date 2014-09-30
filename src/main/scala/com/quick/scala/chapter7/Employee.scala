//层级嵌套包名 结果等价于 串联式包名 package com.quick.scala.chapter7
//但是实际和串联式包名是有区别的，就是父包可见性的区别，见Class7——2
package com {

  package quick {

    package scala {

      package chapter7 {

        class Employee {

          private var name = "I am a 层级包名类"

          def desc()={
            """看看这包名定义，就是那么随意。java程序员看者比较别扭，
              不过scala完全支持java的那种串联方式，所以放心地用吧"""
          }

        }
      }
    }
  }
}

package com {
  package quick {
    package scala {
      package chapter7 {
        package student {

          class Student {
            var location = "我在的文件和我的package不是一样的哦"

            def desc = {
              this.getClass.getPackage
            }

          }

        }
      }
    }
  }
}

