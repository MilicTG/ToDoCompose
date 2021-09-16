package dev.milic.to_docompose.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import dev.milic.to_docompose.ui.theme.topAppBarBackgroundColor
import dev.milic.to_docompose.ui.theme.topAppBarContentColor
import dev.milic.to_docompose.R
import dev.milic.to_docompose.data.models.Priority

@Composable
fun ListAppBar() {
    DefaultListAppBar(onSearchClicked = {})
}

@Composable
fun DefaultListAppBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarActions(onSearchClicked = onSearchClicked)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(onSearchClicked: () -> Unit) {
    SearchAction(onSearchClicked = onSearchClicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = { onSearchClicked }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_task),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(onSortClicked: (Priority) -> Unit) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(id = R.string.sort_task)
        )
    }
}
