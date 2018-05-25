package model

import util.Abhs

object AntiLayer{
    fun toWord(q:String,basicBean: BasicBean):Word{
        return Word(q,basicBean.explains.toString(),basicBean.usphonetic?:"",basicBean.ukphonetic?:""
        , Abhs.nextTime(System.currentTimeMillis(),0),0)
    }
}