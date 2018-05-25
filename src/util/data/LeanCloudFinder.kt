package util.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import model.Word
import util.getRequest

class LeanCloudFinder: Finder(){
    override fun find(): ArrayList<Word> {
        val map = hashMapOf<String,String>()
        val s = getRequest("https://leancloud.cn:443/1.1/classes/word",map)
        val root = JsonParser().parse(s)
        root as JsonObject
        val results = root["results"]
        val t = object : TypeToken<List<Word>>(){}.type
        return ArrayList(Gson().fromJson<List<Word>>(results,t))
    }
}