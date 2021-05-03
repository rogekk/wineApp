package com.example.winemakerapp

import java.util.regex.Pattern

class PasswordValidator {
    val PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=\\S+$)" +
            ".{6,}" +
            "$")                    

    fun validatePassword(password: String): Boolean {
        return PASSWORD_PATTERN.matcher(password).matches()
    } 
}