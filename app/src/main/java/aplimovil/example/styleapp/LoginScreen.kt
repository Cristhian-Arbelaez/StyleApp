package aplimovil.example.styleapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import aplimovil.example.styleapp.Navegacion.AppScreens


@Composable
fun LoginScreen(navController: NavHostController) {
    var usuario by remember {
        mutableStateOf("")
    }
    var contraseña by remember {
        mutableStateOf("")
    }
    var contraselaVisible by remember {
        mutableStateOf(false)
    }
    val infoCorrecta by derivedStateOf {
        usuario.isNotBlank() && contraseña.length >= 7
    }
    Column(
        Modifier.fillMaxSize().background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Image(
            painter = painterResource(id = R.drawable.captura2),
            contentDescription = "App Logo",
            modifier = Modifier.weight(1f).size(800.dp),
            )
        Card(
            Modifier.weight(2f).padding(15.dp),
            shape = RoundedCornerShape(32.dp))
        {
            Column(
                    Modifier.fillMaxSize().padding(32.dp))
            {
                Text(
                    text = "Bienvenido de Nuevo!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp)
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center)
                {
                    Spacer(modifier = Modifier.weight(0.5f))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = usuario,
                        onValueChange = { usuario = it },
                        label = { Text(text = "Usuario") },
                        singleLine = true,
                        trailingIcon = {
                            if (usuario.isNotBlank())
                                IconButton(onClick = { usuario = "" }) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                }
                            }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = contraseña,
                        onValueChange = { contraseña = it },
                        label = { Text(text = "Contraseña") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                        visualTransformation = if (contraselaVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { contraselaVisible = !contraselaVisible }) {
                                Icon(
                                    imageVector = if (contraselaVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = "Mostrar contraseña"
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Button(
                        onClick = {navController.navigate(AppScreens.MainScreen.route)},
                        enabled = infoCorrecta,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(text = "Ingresar")
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    TextButton(onClick = { }) {
                        Text(text = "Olvido su Contraseña?", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(onClick = {}) {
                            Text(text = "Crear Cuenta")
                        }
                    }
                }
            }
        }
    }
}
