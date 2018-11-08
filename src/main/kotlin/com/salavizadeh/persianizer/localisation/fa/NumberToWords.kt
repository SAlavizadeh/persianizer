package com.salavizadeh.persianizer.localisation.fa

import java.util.ArrayList



class NumberToWords {

  private fun unitsMap(): List<String> {
    return listOf("صفر", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه", "ده", "یازده",
        "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده")
  }

  private fun tensMap(): List<String> {
    return listOf("صفر", "ده", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود")
  }

  private fun hundredMap(): List<String> {
    return listOf("صفر", "یکصد", "دویست", "سیصد", "چهارصد", "پانصد", "ششصد", "هفتصد", "هشتصد",
        "نهصد")
  }


  fun toWords(value: Int): String {
    return toWords(value.toLong())
  }

  fun toWords(value: Long): String {
    var number = value
    if (number == 0L)
      return "صفر"

    if (number < 0)
      return "منفی ${toWords((number * -1))}"

    val farsiGroupMap = HashMap<Int, (n: Int) -> String>()

//    farsiGroupMap[Math.pow(10.0, 12.0).toInt()] = { n: Int -> "${toWords(n)} تریلیون" }
    farsiGroupMap[Math.pow(10.0, 9.0).toInt()] = { n: Int -> "${toWords(n)} میلیارد" }
    farsiGroupMap[Math.pow(10.0, 6.0).toInt()] = { n: Int -> "${toWords(n)} میلیون" }
    farsiGroupMap[Math.pow(10.0, 3.0).toInt()] = { n: Int -> "${toWords(n)} هزار" }
    farsiGroupMap[Math.pow(10.0, 2.0).toInt()] = { n: Int -> hundredMap()[n] }


    val parts = ArrayList<String>()

    // just for descending order :~(
    val farsiGroupMap1 = farsiGroupMap.toSortedMap(compareByDescending { it })

    for (group in farsiGroupMap1.keys) {

      if (number / group > 0) {
        parts.add(farsiGroupMap1[group]?.invoke((number / group).toInt())!!)
        number %= group
      }

    }


    if (number >= 20) {
      parts.add(tensMap()[(number / 10).toInt()])
      number %= 10
    }

    if (number > 0) {
      parts.add(unitsMap()[number.toInt()]);
    }


    return parts.joinToString(separator = " و ").trimStart()
  }

  fun toOrdinalWords(value: Int): String {
            if (value == 1)
            {
                return "اول"
            }

            if (value == 3)
            {
                return "سوم"
            }

            if (value % 10 == 3 && value != 13)
            {
                return toWords((value / 10) * 10) + " و سوم"
            }

            val word = toWords(value)
            return word + if(word.endsWith("ی")) " ام" else "م"
  }



}
