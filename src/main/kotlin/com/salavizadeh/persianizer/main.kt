package com.salavizadeh.persianizer

import java.util.Calendar
import java.util.Date

/**
 * Created by SAlavizadeh on 2018-Nov-07
 */

fun main() {
//  println(NumberToWords().toWords(-123_456_789_734_101_111))

  println(123_456_789_067_676.toWords("fa"))

  println(1.toOrdinalWords("fa"))
  println(3.toOrdinalWords("fa"))
  println(11.toOrdinalWords("fa"))
  println(1023847664.toOrdinalWords("fa"))


  println(Date().humanize())
  val date = Calendar.getInstance()   // 19-01-2018
//  date.add(Calendar.HOUR, -7)
  date.add(Calendar.MINUTE, -600)
  println(date.humanize())
  date.add(Calendar.DATE, -7)
  println(date.humanize())

}