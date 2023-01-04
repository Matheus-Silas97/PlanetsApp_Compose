package com.matheussilas97.planetsapp_jetpackcompose.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.matheussilas97.planetsapp_jetpackcompose.models.Planets

@Composable
fun HomeScreen(navController: NavHostController, planets: List<Planets>) {
    val lazyState = rememberLazyListState()
    LazyColumn(state = lazyState) {
        items(planets) { planet ->
            CardPlanet(navController = navController, planet = planet)
        }
    }
}

@Composable
fun CardPlanet(navController: NavHostController, planet: Planets) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(2.dp, color = Color(0x77f5f5f5)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(120.dp)
            .clickable {
                navController.navigate("detailsScreen/${planet.name}/${planet.description}/${planet.image}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = planet.image),
                contentDescription = "planet"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                text = planet.name, style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlanetsAppJetpackComposeTheme {
//        HomeScreen(PlanetsSource.solarSystemList())
    }
}