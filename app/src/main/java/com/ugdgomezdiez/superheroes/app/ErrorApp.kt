package com.ugdgomezdiez.superheroes.app

sealed class ErrorApp {
    object DataError: ErrorApp()
    object InternetError: ErrorApp()
    object UnknowError: ErrorApp()
}