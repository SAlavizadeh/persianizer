package com.salavizadeh.persianizer.formatters

import com.salavizadeh.persianizer.getDateDiff
import java.util.Date
import java.util.concurrent.TimeUnit

class DefaultDateFormatter {

  private var suffix: String = "قبل"

  private fun makeSuffix(difference: Long) {
    suffix = "قبل"
    if (difference > 0) suffix = "از اکنون"
  }

  fun secondFormatter(input: Date, toCompareAgainst: Date): String {
    var difference = input.getDateDiff(toCompareAgainst, TimeUnit.SECONDS)
    makeSuffix(difference)
    difference = Math.abs(difference)

    if (difference > 0.toLong() && difference < 60.toLong()) {
      return (difference).toString() + " ثانیه " + suffix
    }

    return "یک دقیقه $suffix"
  }

  fun minuteFormatter(input: Date, toCompareAgainst: Date): String {
    var difference = input.getDateDiff(toCompareAgainst, TimeUnit.MINUTES)
    makeSuffix(difference)
    difference = Math.abs(difference)
    if (difference > 0.toLong() && difference < 60.toLong()) {
      return (difference).toString() + " دقیقه " + suffix
    }
    return "یک ساعت $suffix"
  }

  fun hourFormatter(input: Date, toCompareAgainst: Date): String {
    var difference = input.getDateDiff(toCompareAgainst, TimeUnit.HOURS)
    makeSuffix(difference)
    difference = Math.abs(difference)
    if (difference > 0.toLong() && difference < 24.toLong()) {
      return (difference).toString() + " ساعت " + suffix
    }
    return "یک روز $suffix"
  }

  fun dayFormatter(input: Date, toCompareAgainst: Date): String {
    var difference = input.getDateDiff(toCompareAgainst, TimeUnit.DAYS)
    makeSuffix(difference)
    if (difference == (-1).toLong()) {
      return "دیروز"
    }
    if (difference == 1.toLong()) {
      return "فردا"
    }
    if (Math.abs(difference) > 1.toLong() && Math.abs(difference) < 31.toLong()) {
      return (Math.abs(difference)).toString() + " روز " + suffix
    }
    return "یک ماه $suffix"
  }

  fun monthFormatter(input: Date, toCompareAgainst: Date): String {
    var difference = getMonthsDifference(input, toCompareAgainst)
    makeSuffix(difference.toLong())
    difference = Math.abs(difference)

    if (Math.abs(difference) > 0.toLong() && Math.abs(difference) < 12.toLong()) {
      return (Math.abs(difference)).toString() + " ماه " + suffix
    }
    return "یک سال $suffix"
  }

  fun yearFormatter(input: Date, toCompareAgainst: Date): String {
    var difference = input.year - toCompareAgainst.year
    makeSuffix(difference.toLong())
    difference = Math.abs(difference)
    return (Math.abs(difference)).toString() + " سال " + suffix
  }

  private fun getMonthsDifference(date1: Date, date2: Date): Int {
    val m1 = date1.year * 12 + date1.month
    val m2 = date2.year * 12 + date2.month
    return m1 - m2
  }
}
