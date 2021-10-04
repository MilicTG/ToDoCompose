package dev.milic.to_docompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.milic.to_docompose.navigation.SetupNavigation
import dev.milic.to_docompose.ui.theme.ToDoComposeTheme
import dev.milic.to_docompose.ui.viewmodels.SharedViewModel

@AndroidEntryPoint
@ExperimentalAnimationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoComposeTheme {
                navHostController = rememberAnimatedNavController()
                SetupNavigation(
                    navHostController = navHostController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}
