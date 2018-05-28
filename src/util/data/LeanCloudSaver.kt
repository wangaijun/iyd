package util.data

import com.google.gson.Gson
import model.Word
import util.data.abs.Saver
import util.postJsonRequest

class LeanCloudSaver: Saver(){
    override fun save(w: Word) {
        super.save(w)
        val url = "https://leancloud.cn:443/1.1/classes/word"
//        val url = "https://p0x9cehn.api.lncld.net/1.1/classes/word"
        postJsonRequest(url, Gson().toJson(w))
    }
}