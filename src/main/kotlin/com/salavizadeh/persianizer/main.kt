package com.salavizadeh.persianizer

import java.util.Calendar
import java.util.Date

/**
 * Created by SAlavizadeh on 2018-Nov-07
 */

fun main() {
//  println(NumberToWords().toWords(-123_456_789_734_101_111))

  println(123_456_789_067_676.toWords("fa"))
  println()
  println(1.toOrdinalWords("fa"))
  println(3.toOrdinalWords("fa"))
  println(11.toOrdinalWords("fa"))
  println(1023847664.toOrdinalWords("fa"))

  println()
  println(Date().humanize())
  val date = Calendar.getInstance()
//  date.add(Calendar.HOUR, -7)
  date.add(Calendar.DATE, +2)
  date.add(Calendar.HOUR, +6)
  println(date.humanize())
  date.add(Calendar.DATE, -7)
  println(date.humanize())

  println()

  println(3333.milliSecondsToTimespan(true))
  println(99000000.milliSecondsToTimespan())

}