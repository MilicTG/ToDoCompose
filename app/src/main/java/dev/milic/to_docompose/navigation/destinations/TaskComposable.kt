package dev.milic.to_docompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import dev.milic.to_docompose.ui.screens.task.TaskScreen
import dev.milic.to_docompose.ui.viewmodels.SharedViewModel
import dev.milic.to_docompose.util.Action
import dev.milic.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import dev.milic.to_docompose.util.Constants.TASK_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            },
        ),
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(durationMillis = 300)
            )
        }
    ) { navStackBackEntry ->
        val taskId = navStackBackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)

        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId = taskId)
        }

        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            navigateToListScreen = navigateToListScreen,
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel
        )
    }
}