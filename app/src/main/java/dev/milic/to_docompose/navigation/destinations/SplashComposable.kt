package dev.milic.to_docompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import dev.milic.to_docompose.ui.screens.splash.SplashScreen
import dev.milic.to_docompose.util.Constants.SPLASH_SCREEN


@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = { _, _ ->
            slideOutVertically(
                targetOffsetY = { -it },
                animationSpec = tween(durationMillis = 300)
            )
        }
    ) {
        SplashScreen(
            navigateToListScreen = navigateToListScreen
        )
    }
}
