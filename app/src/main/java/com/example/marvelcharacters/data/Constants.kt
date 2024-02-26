package com.example.marvelcharacters.data

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val PUBLIC_KEY = "a9b3ec0b7ef1fd715dc4a628862f26b6"
    const val PRIVATE_KEY = "a3f2a7382806c3fae1cdc37db0b052807e561fe2"
    val timestamp = Timestamp(System.currentTimeMillis()).time.toString()

    fun hash(): String {
        val input = "$timestamp$PRIVATE_KEY$PUBLIC_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}