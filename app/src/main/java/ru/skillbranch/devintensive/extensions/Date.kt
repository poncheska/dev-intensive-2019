package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60L* SECOND
const val HOUR = 60L* MINUTE
const val DAY = 24L* HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits):Date{
    var time = this.time
    time += when(units){
        TimeUnits.SECOND -> value* SECOND
        TimeUnits.MINUTE -> value* MINUTE
        TimeUnits.HOUR -> value* HOUR
        TimeUnits.DAY -> value* DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff():String{
    val diff:Long = Date().time-this.time
    when(abs(diff)){
        0L -> return "прямо сейчас"
        in SECOND..MINUTE - SECOND -> {
            return if(diff<0){
                "через ${TimeUnits.SECOND.plural(abs(diff/ SECOND))}"
            }else{
                "${TimeUnits.SECOND.plural(abs(diff/ SECOND))} назад"
            }
        }
        in MINUTE..HOUR - MINUTE -> {
            return if(diff<0){
                "через ${TimeUnits.MINUTE.plural(abs(diff/ MINUTE))}"
            }else{
                "${TimeUnits.MINUTE.plural(abs(diff/ MINUTE))} назад"
            }
        }
        in HOUR..DAY - HOUR -> {
            return if(diff<0){
                "через ${TimeUnits.HOUR.plural(abs(diff/ HOUR))}"
            }else{
                "${TimeUnits.HOUR.plural(abs(diff/ HOUR))} назад"
            }
        }
        in DAY..365* DAY -> {
            return if(diff<0){
                "через ${TimeUnits.DAY.plural(abs(diff/ DAY))}"
            }else{
                "${TimeUnits.DAY.plural(abs(diff/ DAY))} назад"
            }
        }
        else -> {
            return if(diff<0){
                "более чем через год"
            }else{
                "более года назад"
            }
        }
    }
}

enum class TimeUnits {
    SECOND, MINUTE, HOUR, DAY;
    fun plural(value: Long):String{
            when(this){
                SECOND -> {
                    val ending:String = if(abs(value) / 10 %10 == 1L || abs(value)%10 in 5..9){""}
                    else if(abs(value)%10 == 1L){"у"}else{"ы"}
                    return "${abs(value)} секунд$ending"
                }
                MINUTE -> {
                    val ending:String = if(abs(value) / 10 %10 == 1L || abs(value)%10 in 5..9){""}
                    else if(abs(value)%10 == 1L){"у"}else{"ы"}
                    return "${abs(value)} минут$ending"
                }
                HOUR -> {
                    val ending:String = if(abs(value) / 10 %10 == 1L || abs(value)%10 in 5..9){"ов"}
                    else if(abs(value)%10 == 1L){""}else{"а"}
                    return "${abs(value)} час$ending"
                }
                DAY -> {
                    val ending:String = if(abs(value) / 10 %10 == 1L || abs(value)%10 in 5..9){"дней"}
                    else if(abs(value)%10 == 1L){"день"}else{"дня"}
                    return "${abs(value)} $ending"
                }
            }
    }
}