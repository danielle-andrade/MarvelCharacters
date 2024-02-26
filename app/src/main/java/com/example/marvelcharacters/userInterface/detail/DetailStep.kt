package com.example.marvelcharacters.userInterface.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvelcharacters.userInterface.list.ListStep

data class DetailsStep(val id: Int) : Screen {
    @Composable
    override fun Content() {
        SecondaryStep()
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)

    @Composable

    fun SecondaryStep() {
        val viewModel = rememberScreenModel<DetailViewModel>()
        val navigator = LocalNavigator.currentOrThrow

        val character = viewModel.character.value

        LaunchedEffect(id) {
            viewModel.getCharacter(id)
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Return") },
                    navigationIcon = {
                        IconButton(onClick = { navigator.push(ListStep()) }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            },
            content = {
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(22.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = character?.name.orEmpty(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 1.2.em
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    AsyncImage(
                        modifier = Modifier.clip(RoundedCornerShape(5)),
                        model =
                        ImageRequest.Builder(LocalContext.current)
                            .data("${character?.thumbnail?.pathSec}.${character?.thumbnail?.extension}")
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = character?.description.orEmpty(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 1.2.em
                    )
                }
            }
        )
    }
}
