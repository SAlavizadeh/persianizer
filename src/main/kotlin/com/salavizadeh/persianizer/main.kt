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

  println()

  var str = "This is a test for truncate"
  println(str.truncate(14))
  println(str.truncate(20, truncateFrom = TruncateFrom.Left))

  str = "این یک تست است"
  println(str.truncate(5))
  println(str.truncate(7))
  println(str.truncate(10, truncationString = ".."))
  println(str.truncate(11, truncateFrom = TruncateFrom.Left))
  println(str.truncate(8, truncateFrom = TruncateFrom.Left))
  println(str.truncate(7, truncateFrom = TruncateFrom.Left))


}