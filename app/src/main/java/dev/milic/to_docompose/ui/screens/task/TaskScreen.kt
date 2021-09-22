package dev.milic.to_docompose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import dev.milic.to_docompose.data.models.Priority
import dev.milic.to_docompose.data.models.ToDoTask
import dev.milic.to_docompose.ui.viewmodels.SharedViewModel
import dev.milic.to_docompose.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = navigateToListScreen,
                selectedTask = selectedTask
            )
        },
        content = {
            TaskContent(
                title = title,
                description = description,
                priority = priority,
                onTitleChange = { newTitle ->
                    sharedViewModel.updateTitle(newTitle)
                },
                onDescriptionChange = {
                    sharedViewModel.description.value = it
                },
                onPrioritySelected = {
                    sharedViewModel.priority.value = it
                }
            )
        }
    )
}
