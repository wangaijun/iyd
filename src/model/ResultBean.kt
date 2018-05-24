package model

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

    class WebBean {
        var key: String? = null
        var value: List<String>? = null
    }
}
