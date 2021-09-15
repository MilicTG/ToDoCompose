package dev.milic.to_docompose.navigation

import androidx.navigation.NavHostController
import dev.milic.to_docompose.util.Action
import dev.milic.to_docompose.util.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navHostController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit ={taskId ->
        navHostController.navigate("task/$taskId")
    }
}