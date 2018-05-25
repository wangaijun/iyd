package model

data class Word(val q:String, val r:String, val usp:String, val ukp:String){
    override fun toString(): String {
        return "$q\n$r\n$usp\n$ukp)"
    }
}