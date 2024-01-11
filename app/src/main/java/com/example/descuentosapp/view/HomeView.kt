@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.descuentosapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.descuentosapp.components.MainTextField

@SuppressLint("UnusendMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(){
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(text = "App descuentos",
            color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        HomeViewContent(it)
    }
}



@Composable
fun HomeViewContent(paddingValues: PaddingValues){
    Column(modifier= Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }

        MainTextField(value = precio , onValueChange = {precio =it}, label ="precio" )
        MainTextField(value = descuento, onValueChange = {descuento = it} , label = "descuento")
    }

}