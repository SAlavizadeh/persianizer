package com.salavizadeh.persianizer

import com.salavizadeh.persianizer.formatters.DefaultDateFormatter
import java.util.Date
import java.util.concurrent.TimeUnit
import java.util.GregorianCalendar
import java.util.Calendar

fun Date.humanize(): String {
  return this.humanize(GregorianCalendar().time)
}

fun Calendar.humanize(): String {
  return this.time.humanize()
}

fun Date.humanize(toCompareAgainst: Date): String {
  val formatter = DefaultDateFormatter()
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.MILLISECONDS)) <= 500)
    return "now"
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.SECONDS)) < 60)
    return formatter.secondFormatter(this, toCompareAgainst)
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.SECONDS)) < 120)
    return formatter.minuteFormatter(this, toCompareAgainst)
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.MINUTES)) < 60)
    return formatter.minuteFormatter(this, toCompareAgainst)
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.MINUTES)) < 120)
    return formatter.hourFormatter(this, toCompareAgainst)
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.HOURS)) < 24)
    return formatter.hourFormatter(this, toCompareAgainst)
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.HOURS)) < 48)
    return formatter.dayFormatter(this, toCompareAgainst)
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.DAYS)) < 29)
    return formatter.dayFormatter(this, toCompareAgainst)
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.DAYS)) in 29..31) {
    val cal = GregorianCalendar()
    cal.time = this
    if (cal.getActualMaximum(Calendar.DAY_OF_MONTH) <= Math.abs(
            this.getDateDiff(toCompareAgainst, TimeUnit.DAYS)))
      return formatter.dayFormatter(this, toCompareAgainst)
    if (cal.getActualMaximum(Calendar.DAY_OF_MONTH) > 29)
      return formatter.monthFormatter(this, toCompareAgainst)
  }
  if (Math.abs(this.getDateDiff(toCompareAgainst, TimeUnit.DAYS)) < 345)
    return formatter.monthFormatter(this, toCompareAgainst)
  return formatter.yearFormatter(this, toCompareAgainst)
}

// based on this SO answer http://stackoverflow.com/a/10650881
fun Date.getDateDiff(date2: Date, timeUnit: TimeUnit): Long {
  val diffInMillies = this.time - date2.time
  return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS)
}

