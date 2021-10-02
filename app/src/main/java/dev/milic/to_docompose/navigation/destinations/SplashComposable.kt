package dev.milic.to_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.milic.to_docompose.ui.screens.splash.SplashScreen
import dev.milic.to_docompose.util.Constants.SPLASH_SCREEN


fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN
    ) {
        SplashScreen(
            navigateToListScreen = navigateToListScreen
        )
    }
}