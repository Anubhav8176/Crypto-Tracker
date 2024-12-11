package com.plcoding.cryptotracker.crypto.domain

//This is the generic data class that holds the data and does not have any significance to the UI
data class Coins(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double
)
