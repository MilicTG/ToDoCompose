package dev.milic.to_docompose.navigation

import androidx.navigation.NavHostController
import dev.milic.to_docompose.util.Action
import dev.milic.to_docompose.util.Constants.LIST_SCREEN
import dev.milic.to_docompose.util.Constants.SPLASH_SCREEN

class Screens(navHostController: NavHostController) {

    val splash: () -> Unit = {
        navHostController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    val list: (Int) -> Unit = { taskId ->
        navHostController.navigate(route = "task/$taskId")
    }

    val task: (Action) -> Unit = { action ->
        navHostController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}