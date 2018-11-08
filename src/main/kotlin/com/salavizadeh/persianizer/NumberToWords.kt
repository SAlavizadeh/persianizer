package com.salavizadeh.persianizer

import java.util.Locale

/**
 * Created by SAlavizadeh on 2018-Nov-08
 */

fun Int.toWords(language: String = Locale.getDefault().language): String {
  return this.toLong().toWords(language)
}

fun Long.toWords(language: String = Locale.getDefault().language): String {
  return when (language) {
    "fa" -> com.salavizadeh.persianizer.localisation.fa.NumberToWords().toWords(this)
    else -> com.salavizadeh.persianizer.localisation.en.NumberToWords().toWords(this)
  }
}

fun Int.toOrdinalWords(language: String): String {
  return when (language) {
    "fa" -> com.salavizadeh.persianizer.localisation.fa.NumberToWords().toOrdinalWords(this)
    else -> com.salavizadeh.persianizer.localisation.en.NumberToWords().toOrdinalWords(this)
  }
}
