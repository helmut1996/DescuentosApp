@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.descuentosapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.descuentosapp.components.Alert
import com.example.descuentosapp.components.MainButton
import com.example.descuentosapp.components.MainTextField
import com.example.descuentosapp.components.SpaceH
import com.example.descuentosapp.components.SpaceW
import com.example.descuentosapp.components.TowCards

@SuppressLint("UnusendMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "App descuentos",
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        HomeViewContent(it)
    }
}


@Composable
fun HomeViewContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //  verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var descuentoPrecio by remember { mutableDoubleStateOf(0.0) }
        var descuentoTotal by remember { mutableDoubleStateOf(0.0) }
        var showAlert by remember { mutableStateOf(false) }

        TowCards(
            title = "Total",
            number1 = descuentoTotal,
            title2 = "Descuento",
            number2 = descuentoPrecio
        )
        MainTextField(value = precio, onValueChange = { precio = it }, label = "precio")
        SpaceH()
        MainTextField(value = descuento, onValueChange = { descuento = it }, label = "descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento") {
            if (precio != "" && descuento != "") {

                descuentoPrecio = calcularPrecio(precio.toDouble(), descuento.toDouble())
                descuentoTotal =
                    calcularDescuento(precio = precio.toDouble(), descuento = descuento.toDouble())
            } else {
                showAlert = true
            }
        }
        SpaceW()
        MainButton(text = "Limpiar", color = Color.Red) {
            precio = ""
            descuento = ""
            descuentoPrecio = 0.0
            descuentoTotal = 0.0
        }

        if (showAlert) {
            Alert(title = "Alerta",
                message = "Escriba Precio y Descuento",
                comfirmText = "Aceptar",
                onConfirmClick = { showAlert = false }) { }
        }
    }

}

fun calcularPrecio(precio: Double, descuento: Double): Double {
    val result = precio - calcularDescuento(precio, descuento)
    return kotlin.math.round(result * 100) / 100.0
}

fun calcularDescuento(precio: Double, descuento: Double): Double {
    val result = precio * (1 - descuento / 100)
    return kotlin.math.round(result * 100) / 100.0
}