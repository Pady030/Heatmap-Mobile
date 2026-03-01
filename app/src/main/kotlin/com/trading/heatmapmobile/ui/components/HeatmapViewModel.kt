package com.trading.heatmapmobile.ui.components

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HeatmapViewModel : ViewModel() {
    // Das Live-Orderbuch (Preis -> Volumen)
    var liveOrderBook = mutableStateMapOf<Double, Int>()
    var currentPrice = mutableStateOf(18250.0) // Beispiel NQ Preis

    fun updatePrice(newPrice: Double, volume: Int) {
        liveOrderBook[newPrice] = volume
        currentPrice.value = newPrice
    }
}
