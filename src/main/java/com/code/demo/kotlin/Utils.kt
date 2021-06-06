package com.code.demo.kotlin

import com.code.demo.utils.StringUtils

fun isToken(token: String?):Boolean {
    if (token != null) {
        return token.startsWith("-t")
    }
    return false
}