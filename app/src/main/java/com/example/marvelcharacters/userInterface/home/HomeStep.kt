package com.example.marvelcharacters.userInterface.home

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.marvelcharacters.R
import com.example.marvelcharacters.userInterface.list.ListStep
import com.example.marvelcharacters.userInterface.list.ListViewModel

class InitialStep : Screen {
    @Composable
    override fun Content() {
        FirstStep()
    }
    @Composable
    fun FirstStep() {
        val navigator = LocalNavigator.currentOrThrow

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
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.Black),
                onClick = { navigator.push(ListStep()) }
            ) {
                Text(
                    text = "Characters List",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Medium)
            }
        }
    }
}