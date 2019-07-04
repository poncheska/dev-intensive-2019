package com.skillbranch.devintensive.models

import com.skillbranch.devintensive.utils.Utils
import java.security.MessageDigest
import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
){
    abstract fun formatMessage():String
    companion object AbstractFactory{
        private var lastId:Int = -1
        fun makeMessage(from:User?, chat:Chat, date:Date, type:String, payload:Any?):BaseMessage{
            lastId++
            return when(type){
                "text" -> TextMessage("$lastId", from, chat,date = date, text = payload as String)
                else -> ImageMessage("$lastId", from, chat,date = date, image = payload as String)
            }
        }
    }
}