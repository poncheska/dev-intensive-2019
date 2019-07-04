package com.skillbranch.devintensive.extensions

import java.util.regex.Matcher
import java.util.regex.Pattern

fun String.truncate(value:Int=16):String{
    if(this.trimEnd().length<=value){
        return this.trimEnd()
    }else{
        return this.substring(0,value).trimEnd()+"..."
    }
}

fun String.stripHtml():String{
    var result:String = this

    val pattern = Pattern.compile("<.*?>")
    val matcher:Matcher = pattern.matcher(result)
    result = matcher.replaceAll("").toString()

    val pattern1 = Pattern.compile("&.*?;")
    val matcher1:Matcher = pattern1.matcher(result)
    result = matcher1.replaceAll("").toString()

    while(result.contains("  "))
        result=result.replaceFirst("  ", "")

    return result
}