package org.scesi.cappuchino.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberCappuchinoState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): CappuchinoState = remember(navController, coroutineScope){
    CappuchinoState(navController, coroutineScope)
}

class CappuchinoState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
)