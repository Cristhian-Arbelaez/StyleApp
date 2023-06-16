package aplimovil.example.styleapp.Navegacion

import java.net.NoRouteToHostException

sealed class AppScreens(val route: String){
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object HombreScreen: AppScreens("hombre_screen")
    object MujerScreen: AppScreens("mujer_screen")
    object LoginScreen: AppScreens("login_screen")
}