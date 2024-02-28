package com.example.descuentosapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcularViewModel2: ViewModel() {



    //metodo1 para caturar el dato del formumalario
//    fun onValuePrecio(value: String){
//        precio = value
//    }
//    fun onValueDescuento(value: String){
//        descuento = value
//    }

    var precio by mutableStateOf("")
    private set


    var descuento by mutableStateOf("")
        private set

    //metodo2 para caturar el dato del formumalario
    fun onValue(value:String, text:String){
        when(text){
            "precio"-> precio= value
            "descuento" -> descuento = value
        }
    }

    var precioDescuento by mutableDoubleStateOf(0.0)
        private set

    var precioTotal by mutableDoubleStateOf(0.0)
        private set

    var showAlert by mutableStateOf(false)
        private set



    fun Calcular(){


        if (precio != "" && descuento != "") {

            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
            precioTotal = calcularDescuento(precio = precio.toDouble(), descuento = descuento.toDouble())
        } else {
            showAlert = true
        }
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val result = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(result * 100) / 100.0
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val result = precio * (1 - descuento / 100)
        return kotlin.math.round(result * 100) / 100.0
    }

    fun limpiar(){
        precio = ""
        descuento = ""
        precioDescuento = 0.0
        precioTotal = 0.0
    }

    fun cancelAlert(){
        showAlert = false
    }
}


