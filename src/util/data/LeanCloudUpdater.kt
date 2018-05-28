package util.data

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import model.Word
import util.postJsonRequest

class LeanCloudUpdater:Updater(){
    override fun update(word: Word) {
//        val s = Gson().toJson(word)
        val s = "{" +
                "reviewTime:1527212880939," +
                "reviewedCount:2" +
                "}"
        val r = postJsonRequest("https://leancloud.cn:443/1.1/classes/word/${word.objectId}",s)
        println(r)
    }
}