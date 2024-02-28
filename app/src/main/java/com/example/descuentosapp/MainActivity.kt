package com.example.descuentosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.descuentosapp.ui.theme.DescuentosAppTheme
import com.example.descuentosapp.view.HomeView
import com.example.descuentosapp.view.HomeView2
import com.example.descuentosapp.view.HomeView3
import com.example.descuentosapp.viewmodel.CalcularViewModel1
import com.example.descuentosapp.viewmodel.CalcularViewModel2
import com.example.descuentosapp.viewmodel.CalcularViewModel3


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalcularViewModel3 by viewModels()
        setContent {
            DescuentosAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView3(viewModel)
                }
            }
        }
    }
}

