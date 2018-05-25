package model

object AntiLayer{
    fun toWord(q:String,basicBean: BasicBean):Word{
        return Word(q,basicBean.explains.toString(),basicBean.usphonetic?:"",basicBean.ukphonetic?:""
        ,System.currentTimeMillis()+8*60*60*1000,0)
    }
}