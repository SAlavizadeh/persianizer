package com.salavizadeh.persianizer

import java.util.HashMap
import java.util.function.Function

/**
 * Created by SAlavizadeh on 2018-Nov-08
 */
class Test {

  internal fun test() {
    val mm = HashMap<Int, Any>()

    mm[10000] = { n:Int -> "ttt" + n!! }
  }

}
