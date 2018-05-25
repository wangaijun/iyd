package view

import util.data.LeanCloudFinder
import util.data.LeanCloudSaver

fun main(args: Array<String>) {
    println("请稍候，正在获取最新数据")
//    println(System.currentTimeMillis())
    val list = LeanCloudFinder().find()
    println(list)
}