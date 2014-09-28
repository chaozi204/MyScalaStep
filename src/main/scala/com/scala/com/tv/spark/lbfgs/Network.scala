package com.scala.com.tv.spark.lbfgs

import scala.collection.mutable.ArrayBuffer

/**
 * Created on 9/19/14.
 */
class Network {
  class Member(val name:String){
    val contacts = new ArrayBuffer[Network#Member]()
  }

  private val members = new ArrayBuffer[Member]()

  def jon(name:String) = {
    val m = new Member(name)
    members += m
    m
  }
}

object Network{
//  def apply() = new Network()
  def main(args : Array[String]){
    val chatter = new Network()
    val a=chatter.jon("a")
    val b=chatter.jon("b")
    a.contacts += b

    val myFace = new Network()
    val c = myFace.jon("c")
    a.contacts += c
  }

}
