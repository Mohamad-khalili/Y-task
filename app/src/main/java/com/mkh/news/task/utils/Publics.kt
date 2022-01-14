package com.mkh.news.task.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Publics {

    companion object {


        fun convertTime(time:String): String{
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'")
            val outputFormat = SimpleDateFormat("dd-MM-yyyy")
            val date: Date = inputFormat.parse(time)
            val formattedDate: String = outputFormat.format(date)
            return formattedDate


        }
    }
}