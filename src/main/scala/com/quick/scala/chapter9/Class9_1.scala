package com.quick.scala.chapter9

import scala.io.Source
import java.io.{FileInputStream, File}

object Class9_1 {
  def main(args:Array[String]){

    //利用Source对象读取文件
    val source = Source.fromFile("pom.xml","UTF-8")

    //返回迭代器结果
    val allLines = source.getLines()

    //source结果是一个迭代器,可以逐条遍历
    for(line <- allLines){
      println(line)
    }

    //最后用完要关掉文件句柄
    source.close()

    //source只能使用或迭代一次，如果需要重头读取，需要重新打开
    val source1 =  Source.fromFile("pom.xml","UTF-8")

    //可以一次性取出来到一个数组，或数组缓冲中
//    val lines = allLines.toBuffer
    val lines = source1.getLines().toArray
    println(lines.length)
    source1.close()

    val source2 =  Source.fromFile("pom.xml","UTF-8")
    //也可以把整个文件读取成一个字符串
    val contents = source2.mkString
    println(contents.length)
    source2.close()

    //可以将Source对象当做迭代器，因为Source类扩展至Iterator[Char]
    //然后可以读取文件中的字符
    val source3 = Source.fromFile("pom.xml","UTF-8")
    var count=0
    for(char <- source3){
      count += 1
    }
    println(count)
    source3.close()

   ReadFromOther.readFromURL("http://www.baidu.com")
  }
}

/**
 * Source 对象有读取非文件源的方法
 */
object ReadFromOther {

  /**
   * 从URL中读取数据
   * @param url
   */
  def readFromURL (url:String,coding:String = "UTF-8")={
    val source = Source.fromURL(url,coding)
    val content = source.getLines().mkString
    println(content)
    source.close()

  }

  /**
   * 从给定的字符串中读取数据 -- 对调试很有作用
   * @param content
   */
  def readFromString(content:String)={
    val source = Source.fromString(content)
    for(char <- source)
      println(char)
    source.close()
  }

  /**
   * 从标准输入流中读取数据
   * @return
   */
  def readFromStdin()={
    val source = Source.stdin
    val s = source.toArray
    source.close()
    s
  }

  /**
   * Scala没有读取二进制文件的方法，需要使用java的类库完成
   * @param fileName
   */
  def readFromBinaryFile(fileName:String){
    val file = new File(fileName)
    val in = new FileInputStream(file)
    val bytes = new Array[Byte](file.length().toInt)
    in.read(bytes)
    in.close()
  }
}

