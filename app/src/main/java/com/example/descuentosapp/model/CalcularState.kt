package com.example.descuentosapp.model

data class CalcularState(
    val precio:String = "",
    val descuento:String = "",
    val precioDescuento:Double = 0.0,
    val precioTotal:Double = 0.0,
    val showAlert:Boolean = false
)
