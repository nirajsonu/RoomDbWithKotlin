package com.example.roomdbwithkotlin.testing

object RegistrationUtil {

    private val nameOfExistingUsers=listOf<String>("Neeraj","Sonu")

    /**
     * the input is not valid if
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     *...the password contains less than 2 digits
     *
     */


    fun validateRegistrationInput(
        username:String,
        password:String,
        confirmPassword:String
    ):Boolean{
        if(username.isEmpty() || password.isEmpty()){
            return false
        }
        if(username in nameOfExistingUsers){
            return false
        }
        if(password!=confirmPassword){
            return false
        }
        if(password.count { it.isDigit() }>2){
            return false
        }
        return true
    }
}