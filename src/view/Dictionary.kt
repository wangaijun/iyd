package view

import util.MD5.md5
import com.google.gson.Gson
import model.ResultBean
import util.AudioPlayer
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL


fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("第一个参数为查询的单词")
        println("第二个参数是翻译类型，1：英-中，2：中-英，默认为1")
        return
    }
    lookAndPlay(args)
}

fun lookAndPlay(args: Array<String>) {
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
    val message = requestForHttp("http://openapi.youdao.com/api", params)
    println(message)
    val r = Gson().fromJson<ResultBean>(message, ResultBean::class.java)
    val b = r.basic
    println(b)
    playSound(query)
}

fun requestForHttp(urlStr: String, requestParams: Map<String, String>): String {
    val sb = StringBuilder()
    requestParams.forEach{
        k,v->sb.append(k).append("=").append(v).append("&")
    }
    sb.removeSuffix("&")

    val url = URL(urlStr)
    val conn = url.openConnection()
    conn as HttpURLConnection
    conn.doOutput = true
    conn.requestMethod = "POST"
    conn.addRequestProperty("Accept-Charset", "utf-8")
    conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded")
    conn.addRequestProperty("Content-Length", sb.length.toString())

    val os = conn.outputStream
    os.write(sb.toString().toByteArray())
    os.flush()
    val ins = conn.inputStream
    val bis = BufferedInputStream(ins)
    val bs = ByteArray(1024*2)
    val len = bis.read(bs)
    return String(bs,0,len)
}

fun playSound(word:String){
    val player = AudioPlayer()
    player.play(word)
}



