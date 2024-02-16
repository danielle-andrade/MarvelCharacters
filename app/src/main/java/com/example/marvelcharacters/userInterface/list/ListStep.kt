package com.example.marvelcharacters.userInterface.list

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.marvelcharacters.data.CharResponse
import com.example.marvelcharacters.data.CharacterData
import com.example.marvelcharacters.data.CharacterResponse
import com.example.marvelcharacters.domain.Character
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.compose.rememberInstance

object ListStep : ComponentActivity(), DIAware {
    override val di by closestDI()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

    @Composable
    fun ListStep(navController: NavHostController) {
        val viewModel: ListViewModel by rememberInstance()

        LazyColumn(modifier = Modifier.padding(20.dp)) {
            items(viewModel.getList2.value) { character ->
                Row(modifier = Modifier.padding(5.dp)) {
                    Text(
                        text = character.name.orEmpty(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    Button(
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent),
                        onClick = { navController.navigate("detailsStep") }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }
            }
        }

    }
}

//            Row {
//                Button(
//                    modifier = Modifier.weight(1f),
//                    onClick = { navController.navigate("detailsStep") }
//                ) {
//                    Text("GO TO DETAILS")
//                }
//        }


//        Column {
//           // CharacterList(data = testData)
//


//    @Composable
//    fun CharacterList(
//        data: CharacterData?
//             ) {
//        val viewModel: ListViewModel by rememberInstance()
//
//        LazyColumn(
//            modifier = Modifier
//                //   .verticalScroll(rememberScrollState())
//                .padding(22.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {

//           data?.results?.let { character ->
//            items(character) {character ->
//                ListItem(
//                    text = viewModel.getList.value?.results.toString()
//
//                )
//                Divider()
//            }
//
//            }
//        }
//
//    }
//
//    @Composable
//    fun ListItem(text: String) {
//        Text(
//            text = text,
//            style = MaterialTheme.typography.bodySmall
//        )
//    }

//}

