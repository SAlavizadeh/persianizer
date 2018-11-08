package com.salavizadeh.persianizer.exceptions

class NoRuleFoundException(val inflection: String): Exception("Can't ${inflection} this word, could not find a rule to match.")
