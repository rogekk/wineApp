package com.example.winemakerapp.src.main.java

import InputOutput
import UsersRepository
import java.util.*

object ServiceLocator {
    val inputOutput: InputOutput
        get() = InputOutput(GetScanner())

    val usersRepository: UsersRepository
        get() = UsersRepository()

    fun GetScanner(): Scanner {
        return Scanner(System.`in`)
    }
}