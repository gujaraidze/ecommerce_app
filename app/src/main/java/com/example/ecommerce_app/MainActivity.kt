package com.example.ecommerce_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ecommerce_app.ui.theme.Ecommerce_AppTheme
import com.example.ecommerce_app.navigation.AppNavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ecommerce_AppTheme {
                AppNavGraph()
                }
            }
        }
    }




