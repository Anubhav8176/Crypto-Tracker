package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.domain.Coins
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUi
import com.plcoding.cryptotracker.crypto.presentation.models.toCoinUi
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme


@Composable
fun CoinListItem(
    coinUi: CoinUi,
    onClick: ()->Unit,
    modifier: Modifier = Modifier
) {

    val contentColor = if(isSystemInDarkTheme()){
        Color.White
    }else{
        Color.Black
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
        Column{
            Text(
                text = coinUi.symbol,
                fontSize = 18.sp,
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = coinUi.name,
                fontSize = 13.sp,
                color = contentColor,
                fontWeight = FontWeight.Light
            )
        }

        Spacer(modifier = modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            Text(
                text = "$ ${coinUi.priceUsd.formatted}",
                fontSize = 15.sp,
                color = contentColor,
                fontWeight = FontWeight.SemiBold
            )
            PriceChange(
                change = coinUi.changePercent24Hr
            )
        }
    }

}


@PreviewLightDark
@Composable
fun CoinListItemPreview(){
    CryptoTrackerTheme {
        CoinListItem(
            coinUi = previewCoin,
            onClick = {},
            modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)
        )
    }
}

internal val previewCoin = Coins(
    id = "bitcoin",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 1241273958896.75,
    priceUsd = 62828.15,
    changePercent24Hr = -0.1
).toCoinUi()
