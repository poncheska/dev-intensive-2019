package com.skillbranch.devintensive.models

import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text:String?
):BaseMessage(id, from, chat, isIncoming, date){

    override fun formatMessage():String = """
    id = $id
    from = ${from?.firstName} ${from?.lastName}
    isIncoming = ${if(isIncoming) "получил" else "отправил"}
    date = $date
    type = "text"
    """.trimIndent()

}