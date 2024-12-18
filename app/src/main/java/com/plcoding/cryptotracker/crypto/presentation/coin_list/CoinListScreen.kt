package com.plcoding.cryptotracker.crypto.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    state: CoinListState,
    modifier: Modifier = Modifier
) {

    if(state.isLoading){
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        LazyColumn (
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(state.coins){coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = {},
                    modifier = modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }

}