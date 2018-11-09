package com.salavizadeh.persianizer

import com.salavizadeh.persianizer.exceptions.UnsupportedTruncatorException

fun String.truncate(length: Int, truncationString: String = "…", truncator: Truncator = Truncator.FixedLength, truncateFrom: TruncateFrom = TruncateFrom.Right) : String {
    return when (truncator) {
        Truncator.FixedLength -> truncateFixedLength(this, length, truncationString, truncateFrom)
        Truncator.FixedNumberOfCharacters -> truncateFixedNumberOfCharacters(this, length,
            truncationString, truncateFrom)
        Truncator.FixedNumberOfWords -> truncateFixedNumberOfWords(this, length, truncationString,
            truncateFrom)
        else -> throw UnsupportedTruncatorException()
    }
}