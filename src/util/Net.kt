package util

import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

fun postFormRequest(urlStr: String, requestParams: Map<String, String>): String {
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

fun postJsonRequest(urlStr: String, body:String):String{
    val url = URL(urlStr)
    val conn = url.openConnection()
    conn as HttpURLConnection
    conn.doOutput = true
    conn.requestMethod = "POST"
    conn.addRequestProperty("Accept-Charset", "utf-8")
    conn.addRequestProperty("Content-Type", "application/json")
    conn.addRequestProperty("Content-Length", body.length.toString())
    conn.addRequestProperty("X-LC-Id", "P0X9CEHNcfck0qvkuEaP3Dc7-gzGzoHsz")
    conn.addRequestProperty("X-LC-Key", "WL5GuL34xuyg1UFRRbr3lnuv")
    val os = conn.outputStream
    os.write(body.toByteArray())
    os.flush()
    val ins = conn.inputStream
    val bis = BufferedInputStream(ins)
    val bs = ByteArray(1024*2)
    val len = bis.read(bs)
    return String(bs,0,len)
}