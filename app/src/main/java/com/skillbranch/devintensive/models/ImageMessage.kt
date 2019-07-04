package com.skillbranch.devintensive.models

import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image:String?
):BaseMessage(id, from, chat, isIncoming, date){

    override fun formatMessage():String = """
    id = $id
    from = ${from?.firstName} ${from?.lastName}
    isIncoming = ${if(isIncoming) "получил" else "отправил"}
    date = $date
    type = "image"
    """.trimIndent()

}