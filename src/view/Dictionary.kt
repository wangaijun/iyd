package view

import util.MD5.md5
import com.google.gson.Gson
import model.BasicBean
import model.ResultBean
import util.AudioPlayer
import util.postFormRequest


fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("第一个参数为查询的单词")
        println("第二个参数是翻译类型，1：英-中，2：中-英，默认为1")
        return
    }
    lookAndPlay(args)
}

fun lookAndPlay(args: Array<String>):BasicBean? {
    val query = args[0]
    var from = "en"
    var to = "zh-CHS"
    if (args.size >= 2) {
        when (args[1]) {
            "2" -> {
                from = "zh-CHS"
                to = "en"
            }
        }
    }
    val appKey = "6fe6f4309122ff9c"
    val salt = System.currentTimeMillis().toString()
    val sign = md5(appKey + query + salt + "uQZb1iiBhI9PbhMrO18VUamiTXVQsua7")
    val params = hashMapOf<String, String>()
    params.put("q", query)
    params.put("from", from)
    params.put("to", to)
    params.put("sign", sign)
    params.put("salt", salt)
    params.put("appKey", appKey)
    val message = postFormRequest("http://openapi.youdao.com/api", params)
    val r = Gson().fromJson<ResultBean>(message, ResultBean::class.java)
    val b = r.basic
    println(b)
    playSound(query)
    return b
}

fun playSound(word:String){
    val player = AudioPlayer()
    player.play(word)
}



