package model

import com.google.gson.annotations.SerializedName

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