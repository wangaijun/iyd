package util.data.leancloud

import com.google.gson.Gson
import model.Word
import util.data.abs.Updater
import util.putJsonRequest

class LeanCloudUpdater: Updater(){
    override fun update(word: Word) {
        val s = Gson().toJson(word)
        putJsonRequest("https://leancloud.cn:443/1.1/classes/word/${word.objectId}",s)
    }
}