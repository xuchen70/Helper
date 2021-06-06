package com.code.demo.kotlin

fun main() {
    var str = "hpF508FH2sLMJ1DK5351k59pUqpZxvPFX371tdfrzVFN8zAB8MWlLjtuho4a2B2Q"
    println(str.count { letter ->
        letter == 'p'
    })


    var method :(Int) ->String = {
        println(it)
        getStr()
    }

   var temp =  method(6)
    println(temp)
}

fun getStr():String{
    return "============="
}