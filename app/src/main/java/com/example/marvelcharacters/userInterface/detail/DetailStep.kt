package com.example.marvelcharacters.userInterface.detail

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.compose.rememberInstance

object DetailsStep : ComponentActivity(), DIAware {
    override val di by closestDI()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)

    @Composable

    fun SecondaryStep(navController: NavHostController) {
        val viewModel: DetailViewModel by rememberInstance()

        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = { Text("Return") },
//                    navigationIcon = {
//                        IconButton(onClick = { navController.navigate("initialStep") }) {
//                            Icon(
//                                imageVector = Icons.Default.ArrowBack,
//                                contentDescription = null
//                            )
//                        }
//                    }
//                )
//            },
            content = {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(22.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = viewModel.getPicture.value?.name.orEmpty(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 1.2.em
                    )
//                    Spacer(modifier = Modifier.height(10.dp))
//                    AsyncImage(
//                        modifier = Modifier
//                            .clip(RoundedCornerShape(5)),
//                        model = viewModel.nasaPic.value?.url.orEmpty(),
//                        contentDescription = null,
//                    )
//                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = viewModel.getPicture.value?.name.orEmpty(),
                        fontSize = 18.sp,
                        lineHeight = 1.5.em
                    )
                }
            }
        )
    }
}