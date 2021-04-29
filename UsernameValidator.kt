package com.example.winemakerapp

import Database
import SharedPreferencesDatabase

class UsernameValidator(val database: Database) {
    
    fun Validator(username: String, password: String): Boolean {

        fun usernameValidation(username: String): Boolean {
            val user = database.selectByUsername(username)

            if (user != null) return true else return false
        }

        fun passwordValidation(password: String): Boolean {
        val password = database.selectByUsername(password)

        if (
    }
    }
    
    
}