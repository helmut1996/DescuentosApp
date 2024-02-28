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
import com.example.descuentosapp.viewmodel.CalcularViewModel2

@SuppressLint("UnusendMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView2(viewModel2: CalcularViewModel2) {
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
        HomeViewContent2(it,viewModel2)
    }
}


@Composable
fun HomeViewContent2(paddingValues: PaddingValues,viewModel2: CalcularViewModel2) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //  verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TowCards(
            title = "Total",
            number1 = viewModel2.precioTotal,
            title2 = "Descuento",
            number2 = viewModel2.precioDescuento
        )
        MainTextField(value = viewModel2.precio, onValueChange = { viewModel2.onValue(it, "precio") }, label = "precio")
        SpaceH()
        MainTextField(value = viewModel2.descuento, onValueChange = { viewModel2.onValue(it,"descuento") }, label = "descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento") {

                viewModel2.Calcular()
        }
        SpaceW()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel2.limpiar()
        }

        if (viewModel2.showAlert) {
            Alert(title = "Alerta",
                message = "Escriba Precio y Descuento",
                comfirmText = "Aceptar",
                onConfirmClick = { viewModel2.cancelAlert() }) { }
        }
    }

}

