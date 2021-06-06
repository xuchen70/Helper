package com.code.demo.kotlin

fun String?.isEmpty():Boolean{
    return this == null || this == ""
}

fun String.isToken():Boolean{
    if (this.isEmpty()) return false
    return this.startsWith("-t") && this.length > 64
}

fun String.matches(regex: String): Boolean {
    return this.matches(regex.toRegex())
}