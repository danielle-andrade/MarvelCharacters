package com.example.marvelcharacters.userInterface.home

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.marvelcharacters.R

object InitialStep : ComponentActivity() {

    @Composable
    fun FirstStep(navController: NavController) {
        Image(
            painter = painterResource(id = R.drawable.marvel),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier.padding(vertical = 50.dp),
                onClick = { navController.navigate("listStep") }
            ) {
                Text("click to see")
            }
        }
    }
}