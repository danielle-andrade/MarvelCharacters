package com.example.marvelcharacters.userInterface.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.marvelcharacters.domain.Character
import com.example.marvelcharacters.userInterface.detail.DetailsStep
import org.kodein.di.compose.rememberInstance


class ListStep : Screen {
    @Composable
    override fun Content() {
        SearchBar()
    }


    @Composable
    fun SearchBar() {
        val viewModel: ListViewModel by rememberInstance()
        val lista by viewModel.filteredProducts.collectAsState(initial = emptyList())

        Column {
            var textvalue by remember { mutableStateOf("") }

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textvalue,
                onValueChange = {
                    textvalue = it
                    viewModel.searchProducts(textvalue)
                },
                label = { Icon(imageVector = Icons.Default.Search, contentDescription = "Input") },
                keyboardOptions = KeyboardOptions.Default,
                textStyle = MaterialTheme.typography.bodyMedium,
                singleLine = false
            )
            ListContent(lista)
        }

    }

    @Composable
    internal fun ListContent(
        lista: List<Character> = emptyList(),
   //     listState: LazyListState
    ) {
        val viewModel: ListViewModel by rememberInstance()
        val navigator = LocalNavigator.currentOrThrow
        val charactersState = remember { mutableStateOf<List<Character>>(emptyList()) }
        val (isLoading, setIsLoading) = remember { mutableStateOf(false) }
        val (shouldLoadMore, setShouldLoadMore) = remember { mutableStateOf(true) }
        val coroutineScope = rememberCoroutineScope()

        val characters = viewModel._getListFiltered


        LazyColumn(modifier = Modifier.padding(20.dp)) {
            items(lista) { character ->
                Row(modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = character.name.orEmpty(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent
                        ),
                        onClick = {
                            navigator.push(DetailsStep(character.id)) })
                    {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }
                Divider()
            }
        }
    }
}
