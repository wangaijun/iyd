package util

import model.Word
import util.data.LeanCloudSaver

object WordsNote{
    fun save(word:Word){
//        Saver().save(word)
        LeanCloudSaver().save(word)
    }
}