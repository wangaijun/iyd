package util.data.leancloud

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import model.Word
import util.data.abs.Finder
import util.getRequest
import java.util.*

class LeanCloudFinder: Finder(){
    override fun find(): ArrayList<Word> {
        val map = hashMapOf<String,String>()
//        map["where"] = "reviewTime<" + (System.currentTimeMillis()-24*60*60*1000).toString()
        val s = getRequest("https://leancloud.cn:443/1.1/classes/word",map)
        val root = JsonParser().parse(s)
        root as JsonObject
        val results = root["results"]
        val t = object : TypeToken<List<Word>>(){}.type
        return ArrayList(Gson().fromJson<List<Word>>(results,t))
    }
}