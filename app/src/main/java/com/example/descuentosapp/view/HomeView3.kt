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
import com.example.descuentosapp.viewmodel.CalcularViewModel3

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusendMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView3(viewModel3: CalcularViewModel3) {
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
        HomeViewContent3(it,viewModel3)
    }
}


@Composable
fun HomeViewContent3(paddingValues: PaddingValues,viewModel3: CalcularViewModel3) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //  verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel3.state
        TowCards(
            title = "Total",
            number1 = state.precioTotal,
            title2 = "Descuento",
            number2 = state.precioDescuento
        )
        MainTextField(value = state.precio, onValueChange = { viewModel3.onValue(it, "precio") }, label = "precio")
        SpaceH()
        MainTextField(value = state.descuento, onValueChange = { viewModel3.onValue(it,"descuento") }, label = "descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento") {
            viewModel3.Calcular()

        }
        SpaceW()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel3.limpiar()
        }

        if (state.showAlert) {
            Alert(title = "Alerta",
                message = "Escriba Precio y Descuento",
                comfirmText = "Aceptar",
                onConfirmClick = { viewModel3.cancelAlert() }) { }
        }
    }

}