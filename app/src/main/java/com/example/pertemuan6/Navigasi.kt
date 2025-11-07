package com.example.pertemuan6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan6.view.FormIsian
import com.example.pertemuan6.view.TampilData
import androidx.navigation.compose.composable


enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,

            modifier = Modifier.padding(paddingValues = isiRuang)){
            composable(route = Navigasi.Formulirku.name) {
                FormIsian(
                    OnSubmitBtnClick = {
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = {
                        cancelAndBackToFormulir(navController)
                    }
                )
            }
        }
    }
}

