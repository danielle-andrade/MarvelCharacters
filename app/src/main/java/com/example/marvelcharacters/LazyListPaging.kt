package com.example.marvelcharacters

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.filter

/**
 * Gerenciador para Lazy Lists com scroll infinito. Quando o index do último item visível for maior que
 * a quantidade de itens na lista + o offset, o callback para carregar mais items será acionado.
 * @param state LazyListState que será usado na comparação. Para que o handler funcione a LazyRow/LazyColumn
 * deve receber esse mesmo state por parâmetro.
 * @param offset Offset para permitir que o callback seja emitido antes de chegar ao final da lista.
 * Caso offset seja 1 o callback será acionado quando a lista chegar no penúltimo item e assim em diante.
 * Por padrão o offset é 0, então o callback é sempre chamado quando a lista chega ao fim.
 * @param loadNext Callback que será executado quando a lista chegar no final considerando o offset.
 * @param isLoading Informa ao componente que o carregamento da página atual ainda está em processamento,
 * caso seja verdadeiro a próxima página só irá ser carregada quando a atual for finalizada.
 * @param shouldLoadMore Informa ao componente que existe uma próxima página a ser carregada.
 * */
@Composable
public fun LazyListPaging(
    state: LazyListState,
    buffer: Int = 2,
    loadNext: () -> Unit,
    isLoading: Boolean,
    shouldLoadMore: Boolean
) {
    val shouldLoadNext = remember(isLoading, shouldLoadMore) {
        derivedStateOf {
            if (isLoading.or(shouldLoadMore.not())) false
            else {
                val layoutInfo = state.layoutInfo
                val totalItemsNumber = layoutInfo.totalItemsCount
                val lastVisibleItemIndex =
                    (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1

                lastVisibleItemIndex >= (totalItemsNumber - buffer)
            }
        }
    }

    LaunchedEffect(shouldLoadNext) {
        snapshotFlow { shouldLoadNext.value }
            .filter { it }
            .collect {
                loadNext()
            }
    }
}

@Composable
public fun LazyListPaging(
    state: LazyListState,
    buffer: Int = 2,
    loadNext: () -> Unit
) {
    val shouldLoadNext = remember {
        derivedStateOf {
            val layoutInfo = state.layoutInfo
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex =
                (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1

            lastVisibleItemIndex >= (totalItemsNumber - buffer)
        }
    }

    LaunchedEffect(shouldLoadNext) {
        snapshotFlow { shouldLoadNext.value }
            .filter { it }
            .collect {
                loadNext()
            }
    }
}