package com.expeknow.day8_chatapp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.expeknow.day8_chatapp.ui.windows.ChatWindow
import com.expeknow.day8_chatapp.ui.windows.MainWindow
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            MainWindow(navController)
        }
        composable(route = "chat") {
            ChatWindow(navController)
        }
    }


}