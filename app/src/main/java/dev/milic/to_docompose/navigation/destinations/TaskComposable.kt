package dev.milic.to_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import dev.milic.to_docompose.ui.screens.task.TaskScreen
import dev.milic.to_docompose.util.Action
import dev.milic.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import dev.milic.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            },
        )
    ) { navStackBackEntry ->

        val taskId = navStackBackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        TaskScreen(navigateToListScreen = navigateToListScreen)
    }
}