package com.rital.myexpensetracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rital.myexpensetracker.ui.addExpense.AddExpenseScreen
import com.rital.myexpensetracker.ui.home.HomeScreen
import com.rital.myexpensetracker.utils.Constatnts

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Constatnts.HOME_SCREEN) {
        composable(Constatnts.ADD_EXPENSE_SCREEN) {
            AddExpenseScreen(navController)
        }
        composable(Constatnts.HOME_SCREEN) {
             HomeScreen(navController) // Uncomment this line when you have a HomeScreen composable") {

        }
    }
}