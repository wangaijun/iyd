package applayer

import model.Word
import util.data.leancloud.LeanCloudSaver

object WordsNote{
    fun save(word:Word){
//        Saver().save(word)
        LeanCloudSaver().save(word)
    }
}