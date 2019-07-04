package ru.skillbranch.devintensive.utils

import android.service.voice.AlwaysOnHotwordDetector

object Utils{
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parts:List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(1)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun toInitials(firstName:String?, lastName:String?):String?{
        return firstName?.getOrNull(0 )?.toString() + lastName?.getOrNull(0)?.toString()
    }

    fun transliteration(payload: String, divider:String = " "):String{
        var result:String = ""
        val array1: Array<String> = arrayOf("а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с",
            "т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я","А","Б","В","Г","Д","Е","Ё","Ж","З","И","Й","К","Л",
            "М","Н","О","П","Р","С", "Т","У","Ф","Х","Ц","Ч","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я"," ")
        val array2: Array<String> = arrayOf("a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n",
            "o", "p", "r", "s", "t", "u", "f", "h", "c", "ch", "sh", "sh'","","i","","e","yu","ya","A", "B", "V", "G",
            "D", "E", "E", "Zh", "Z", "I", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "C", "Ch",
            "Sh", "Sh'","","I","","E","Yu","Ya",divider)
        for(i in 0 until payload.length){
            result += if(array1.contains(payload[i].toString())){
                array2[array1.indexOf(payload[i].toString())]
            }else{
                payload[i].toString()
            }
        }
        return result
    }
}