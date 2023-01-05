package com.matheussilas97.planetsapp_jetpackcompose

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.matheussilas97.planetsapp_jetpackcompose.models.Planets
import com.matheussilas97.planetsapp_jetpackcompose.ui.theme.HomeScreen
import com.matheussilas97.planetsapp_jetpackcompose.ui.theme.PlanetsAppJetpackComposeTheme
import kotlinx.parcelize.Parcelize

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetsAppJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationComponent()
                }
            }
        }
    }

    @Composable
    private fun NavigationComponent() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "homeScreen") {
            composable(route = "homeScreen") {
                HomeScreen(navController = navController, planets = PlanetsSource.solarSystemList())
            }
            composable(
                route = "detailsScreen/{name}/{description}/{image}",
                arguments = listOf(navArgument("name") { type = NavType.StringType },
                    navArgument("description") { type = NavType.StringType },
                    navArgument("image") { type = NavType.IntType })
            ) {
                val arguments = requireNotNull(it.arguments)
                var planetName = ""
                var planetDescription = ""
                var planetImage = 0
                arguments.getString("name")?.let { planet -> planetName = planet }
                arguments.getString("description")?.let { planet -> planetDescription = planet }
                planetImage = arguments.getInt("image")

                val planet =
                    Planets(name = planetName, description = planetDescription, image = planetImage)

                DetailsScreen(navController = navController, planet = planet)
            }
        }
    }
}

