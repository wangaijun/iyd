package view

import util.AudioPlayer
import util.data.LeanCloudFinder
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("请稍候，正在获取最新数据")
//    println(System.currentTimeMillis())
    val list = LeanCloudFinder().find()
    val ct = System.currentTimeMillis()
    val rl = list.filter { it.reviewTime< ct }
    println("已获取待复习的词")
    rl.forEach{
        println(it.q)
        println("1:详细信息,2:读音,3:信息加发音,4:认识")
        val line = scanner.nextLine()
        when(line){
            "1"->System.out.println(it)
            "2"->AudioPlayer().play(it.q)
            "3"->{
                System.out.println(it)
                AudioPlayer().play(it.q)
            }
        }
    }
}