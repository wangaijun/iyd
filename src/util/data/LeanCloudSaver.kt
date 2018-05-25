package util.data

import model.Word
import java.net.URL

class LeanCloudSaver:Saver(){
    override fun save(w: Word) {
        super.save(w)
        val url = URL("https://leancloud.cn:443/1.1/classes/word")
        val conn = url.openConnection()

    }
}