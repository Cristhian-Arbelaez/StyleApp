package aplimovil.example.styleapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import aplimovil.example.styleapp.Navegacion.AppScreens
import kotlinx.coroutines.delay


@Composable
fun MainScreen(navController: NavHostController) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.iniciostyle),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column (
            modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Button(
            onClick = {navController.navigate(AppScreens.HombreScreen.route)},
            shape = CutCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF7A7A7A),
            )
        ) {
            Text(
                "Hombre",
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.size(40.dp))
        Button(
            onClick = {navController.navigate(AppScreens.MujerScreen.route)},
            shape = CutCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF7A7A7A),
            )
        ) {
            Text(
                "  Mujer  ",
                fontWeight = FontWeight.Bold
            )
        }
    }
    }
}
