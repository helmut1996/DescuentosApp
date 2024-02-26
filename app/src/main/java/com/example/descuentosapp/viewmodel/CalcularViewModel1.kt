package com.example.descuentosapp.viewmodel

import androidx.lifecycle.ViewModel

class CalcularViewModel1:ViewModel() {

    fun Calcular(precio:String,descuento:String): Pair<Double, Pair<Double,Boolean>>{
        var precioDescuento =0.0
        var totalDescuento =0.0
        var showAlert = false

        if (precio != "" && descuento != "") {

            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
            totalDescuento = calcularDescuento(precio = precio.toDouble(), descuento = descuento.toDouble())
        } else {
            showAlert = true
        }
        return Pair(precioDescuento,Pair(totalDescuento,showAlert))
    }

   private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val result = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(result * 100) / 100.0
    }

   private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val result = precio * (1 - descuento / 100)
        return kotlin.math.round(result * 100) / 100.0
    }
}