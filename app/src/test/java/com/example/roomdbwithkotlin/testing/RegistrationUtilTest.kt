package com.example.roomdbwithkotlin.testing


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty username return false`(){
        val result=RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun `correct username,password and confirm password`(){
        val result=RegistrationUtil.validateRegistrationInput(
            "Sonu",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun `username already exists returns false`(){
        val result=RegistrationUtil.validateRegistrationInput(
            "Neeraj",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun `empty password return false`(){
        val result=RegistrationUtil.validateRegistrationInput(
            "Neeraj",
            "",
            ""
        )
        assertThat(result).isFalse()

    }

    @Test
    fun `password was repeated incorrectly returns false`(){
        val result=RegistrationUtil.validateRegistrationInput(
            "Neeraj",
            "1234",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`(){
        val result=RegistrationUtil.validateRegistrationInput(
            "Neeraj",
            "1",
            "1"
        )

        assertThat(result).isFalse()
    }



}