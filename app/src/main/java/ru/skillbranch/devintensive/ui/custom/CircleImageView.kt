package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView

class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr:Int = 0
): ImageView(context,attrs,defStyleAttr){
    companion object{
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
    }
}