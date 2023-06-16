package aplimovil.example.styleapp.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aplimovil.example.styleapp.*

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreens.MainScreen.route){
            MainScreen(navController)
        }
        composable(AppScreens.HombreScreen.route){
            HombreScreen(navController)
        }
        composable(AppScreens.MujerScreen.route){
            MujerScreen(navController)
        }
        composable(AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
    }
}