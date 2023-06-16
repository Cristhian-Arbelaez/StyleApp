package aplimovil.example.styleapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import aplimovil.example.styleapp.Navegacion.AppScreens

@Composable
fun HombreScreen(navController: NavHostController) {
    Box(Modifier.verticalScroll(rememberScrollState())) {
        Image(
            modifier = Modifier.fillMaxWidth().offset(0.dp, (-2).dp),
            painter = painterResource(id = R.drawable.captura),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Column {
            Row(
                Modifier.padding(20.dp).height(48.dp).offset(0.dp, (94).dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Busca Tu Nuevo Look", fontSize = 15.sp) },
                    singleLine = true,
                    leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search") },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {navController.navigate(AppScreens.LoginScreen.route)}) {
                    Icon(imageVector = Icons.Outlined.Menu, contentDescription = "", tint = Color.White)
                }
                IconButton(onClick = {navController.navigate(AppScreens.MainScreen.route)}) {
                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "", tint = Color.White)
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "", tint = Color.White)
                }
            }
            ContenidoHombre()
        }
    }
}


@Composable
fun ContenidoHombre() {
    Column {
        Spacer(modifier = Modifier.height(120.dp))
        PromocionHombre()
        Spacer(modifier = Modifier.height(16.dp))
        CategoriasHombre()
        Spacer(modifier = Modifier.height(16.dp))
        MasVendido()
        Spacer(modifier = Modifier.height(16.dp))
        MasBuscado()
    }
}

@Composable
fun PromocionHombre() {
    LazyRow(
        Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromocionHombreItem(
                imagePainter = painterResource(id = R.drawable.camisahombre),
                title = "Camisetas",
                subtitle = "Desde",
                header = "$30.000",
                backgroundColor = MaterialTheme.colors.primary
            )
        }
        item {
            PromocionHombreItem(
                imagePainter = painterResource(id = R.drawable.pantalonhombre1),
                title = "Pantalones",
                subtitle = "Desde",
                header = "$60.000",
                backgroundColor = Color(0xff6EB6F5)
            )
        }
    }
}

@Composable
fun PromocionHombreItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Row {
            Column(
                Modifier.padding(horizontal = 16.dp).fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier.fillMaxHeight().weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun CategoriasHombre() {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categorías",
                style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(
                    text = "Más",
                    color = MaterialTheme.colors.primary)
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoriaBoton(
                text = "Camisetas",
                icon = painterResource(id = R.drawable.camisahombre1),
                backgroundColor = Color(0xffFEF4E7)
            )
            CategoriaBoton(
                text = "Pantalones",
                icon = painterResource(id = R.drawable.pantalonhombre2),
                backgroundColor = Color(0xffF6FBF3)
            )
            CategoriaBoton(
                text = "Buzos",
                icon = painterResource(id = R.drawable.buzo1),
                backgroundColor = Color(0xffFFFBF3)
            )
            CategoriaBoton(
                text = "Chaquetas",
                icon = painterResource(id = R.drawable.chaqueta2),
                backgroundColor = Color(0xffF6E6E9)
            )
        }
    }
}

@Composable
fun CategoriaBoton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier.width(80.dp).clickable { }
    ) {
        Box(
            Modifier.size(80.dp).background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)).padding(18.dp)
        ) {
            Image(
                painter = icon,
                contentDescription = "",
                modifier = Modifier.fillMaxSize())
        }
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp)
    }
}

@Composable
fun MasVendido() {
    Column {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Lo Más Vendido",
                style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(
                    text = "Más",
                    color = MaterialTheme.colors.primary)
            }
        }
        MasVendidoItems()
    }
}

@Composable
fun MasVendidoItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            MasVendidoItem(
                imagePainter = painterResource(id = R.drawable.chaqueta1),
                title = "Chaqueta",
                price = "70.000"
            )
        }
        item {
            MasVendidoItem(
                imagePainter = painterResource(id = R.drawable.camisahombre_2jpg),
                title = "Camisa",
                price = "50.000"
            )
        }
        item {
            MasVendidoItem(
                imagePainter = painterResource(id = R.drawable.pantalonhombre1),
                title = "Pantalon",
                price = "60.000"
            )
        }
        item {
            MasVendidoItem(
                imagePainter = painterResource(id = R.drawable.buzo2),
                title = "Meat",
                price = "55.000"
            )
        }
    }
}

@Composable
fun MasVendidoItem(
    title: String = "",
    price: String = "",
    discountPercent: Int = 0,
    imagePainter: Painter
) {
    Card(
        Modifier.width(160.dp)
    ) {
        Column(
            Modifier.padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Row {
                    Text("$${price}"
                    )
                }
            }
        }
    }
}

@Composable
fun MasBuscado() {
    Column() {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Lo Más Buscado",
                style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(
                    text = "Más",
                    color = MaterialTheme.colors.primary)
            }
        }
        MasBuscadoItems()
    }
}

@Composable
fun MasBuscadoItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            MasBuscadoItem(
                imagePainter = painterResource(id = R.drawable.chaqueta2),
                title = "Chaqueta",
                price = "120.000"
            )
        }
        item {
            MasBuscadoItem(
                imagePainter = painterResource(id = R.drawable.pantalonhombre2),
                title = "Apple",
                price = "60.000"
            )
        }
        item {
            MasBuscadoItem(
                imagePainter = painterResource(id = R.drawable.buzo1),
                title = "Meat",
                price = "90.000"
            )
        }
        item {
            MasBuscadoItem(
                imagePainter = painterResource(id = R.drawable.chaqueta1),
                title = "Meat",
                price = "145.000"
            )
        }
    }
}

@Composable
fun MasBuscadoItem(
    title: String = "",
    price: String = "",
    discountPercent: Int = 0,
    imagePainter: Painter
) {
    Card(
        Modifier.width(160.dp)
    ) {
        Column(
            Modifier.padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold)
                Row {
                    Text("$${price}"
                    )
                }
            }
        }
    }
}