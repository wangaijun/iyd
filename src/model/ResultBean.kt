package model

import com.google.gson.annotations.SerializedName

/**
 * Created by zhaodx on 2018/5/24.
 */

class ResultBean {
    var tSpeakUrl: String? = null
    var query: String? = null
    var errorCode: String? = null
    var dict: DictBean? = null
    var webdict: WebdictBean? = null
    var basic: BasicBean? = null
    var l: String? = null
    var speakUrl: String? = null
    var web: List<WebBean>? = null
    var translation: List<String>? = null

    class DictBean {
        var url: String? = null
    }

    class WebdictBean {
        var url: String? = null
    }

    class BasicBean {
        @SerializedName("us-phonetic")
        var usphonetic: String? = null
        var phonetic: String? = null
        @SerializedName("uk-phonetic")
        var ukphonetic: String? = null
        @SerializedName("uk-speech")
        var ukspeech: String? = null
        @SerializedName("us-speech")
        var usspeech: String? = null
        var explains: List<String>? = null
        override fun toString(): String {
            return "词义：$explains\n"+
                    "美标：$usphonetic\n" +
                    "英标：$ukphonetic\n"
        }
    }

    class WebBean {
        var key: String? = null
        var value: List<String>? = null
    }
}
