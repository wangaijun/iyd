package view

import util.AudioPlayer
import java.util.*

fun main(args: Array<String>) {
    System.out.println("单词 翻译方向(1 英-中(默认)，2 中-英)")
    val scanner = Scanner(System.`in`)
    val line = scanner.nextLine()
    val ss = line.split("[\\s]")
    lookAndPlay(ss.toTypedArray())
    System.out.println("按1播放声音，按0退出")
    while (true){
        val op = scanner.nextLine()
        when(op){
            "1"->AudioPlayer().play(ss[0])
            "0"->System.exit(0)
        }
    }
}