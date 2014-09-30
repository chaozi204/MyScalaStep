package com.quick.scala{
  object SuperPackage {
    def desc(){
      println("object SuperPackage 包路径为："+SuperPackage.getClass.getPackage)
    }
  }
}

package com.quick.scala.chapter7{

  object Class7_3 {
    def desc{
      println("object Class7_3 的包路径为："+Class7_3.getClass.getPackage)
    }
  }


  package child1{

    object A extends App{
      println("object A 的包路径为："+A.getClass.getPackage)

      /**
       * 能直接使用父包中的成员，如Class7_3（层级定义中的）
       * 但是不能直接使用com.quick.scala的成员，因为那段是串联式的包定义的
       *
       */
      println("可以直接调用层级定义包中的父包成员，如如Class7_3.desc")
      //注意我没有加包前缀
      Class7_3.desc

      /**
       * 可以如下访问SuperPackage：com.quick.scala.SuperPackage
       *
       * 但是不能直接访问：SuperPackage.desc()
       */
      com.quick.scala.SuperPackage.desc()
    }

  }
}