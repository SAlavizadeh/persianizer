package com.salavizadeh.persianizer

fun Int.milliSecondsToTimespan(milliSecondPrecision: Boolean = false): String {
    return this.toLong().milliSecondsToTimespan(milliSecondPrecision)
}

// Honestly stolen from here http://stackoverflow.com/a/2795991
fun Long.milliSecondsToTimespan(milliSecondPrecision: Boolean = false): String {
    val sb = StringBuffer()
    val diffInSeconds = this / 1000
    val milliseconds = this % 1000
    val seconds = if (diffInSeconds >= 60) diffInSeconds % 60 else diffInSeconds
    val minutes = if ((diffInSeconds / 60) >= 60) (diffInSeconds / 60) % (60) else diffInSeconds / 60
    val hours = if ((diffInSeconds / 3600) >= 24) (diffInSeconds / 3600) % (24) else diffInSeconds / 3600
    val days = diffInSeconds / 60 / 60 / 24

    if (days > 0) {
        sb.append("$days روز")
        sb.append(" و ")
    }

    if (hours > 0 || days > 0) {
        sb.append("$hours ساعت")
        sb.append(" و ")
    }

    if (minutes > 0 || hours > 0 || days > 0) {
        sb.append("$minutes دقیقه")
        sb.append(" و ")
    }

    sb.append("$seconds ثانیه")

    if (milliSecondPrecision) {
        sb.append(" و ")
        sb.append("$milliseconds میلی ثانیه")
    }
    return sb.toString()
}