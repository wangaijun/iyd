package view

import model.AntiLayer
import util.AudioPlayer
import util.WordsNote
import java.util.*

fun main(args: Array<String>) {
    System.out.println("单词 翻译方向(1 英-中(默认)，2 中-英)")
    val scanner = Scanner(System.`in`)
    val line = scanner.nextLine()
    val ss = line.split("[\\s]")
    val basicBean = lookAndPlay(ss.toTypedArray())
    System.out.println("按1播放声音，按2存入单词本，按0退出")
    while (true){
        val op = scanner.nextLine()
        val q = ss[0]
        when(op){
            "1"->AudioPlayer().play(q)
            "2"->if (basicBean!=null)WordsNote.save(AntiLayer.toWord(q,basicBean))
            "0"->System.exit(0)
        }
    }
}