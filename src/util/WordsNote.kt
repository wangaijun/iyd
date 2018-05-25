package util

import model.Word
import util.data.LeanCloudSaver
import util.data.Saver

object WordsNote{
    fun save(word:Word){
//        Saver().save(word)
        LeanCloudSaver().save(word)
    }
}