package com.example.marvelcharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.navigator.Navigator
import com.example.marvelcharacters.ui.theme.MarvelCharactersTheme
import com.example.marvelcharacters.userInterface.detail.DetailViewModel
import com.example.marvelcharacters.userInterface.detail.DetailsStep
import com.example.marvelcharacters.userInterface.home.InitialStep
import com.example.marvelcharacters.userInterface.list.ListStep

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MarvelCharactersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                //    MarvelCharacters()
                    Navigator(InitialStep())
                }
            }
        }
    }

    @Composable
    fun MarvelCharacters() {
//        val navController = rememberNavController()
//
//        NavHost(
//            navController = navController,
//            startDestination = "initialStep"
//        )
//        {
//            composable("initialStep") {
//                FirstStep(navController)
//            }
//            composable("listStep") {
//                ListStep(navController)
//            }
//            composable("detailsStep/{characterId}") {backStackEntry ->
//                SecondaryStep(navController)
//            }
//        }
    }
}