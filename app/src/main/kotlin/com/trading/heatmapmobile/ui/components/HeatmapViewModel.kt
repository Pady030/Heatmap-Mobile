package com.trading.heatmapmobile.ui.components

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HeatmapViewModel : ViewModel() {
    val liveOrderBook = mutableStateMapOf<Double, Int>()
    val currentPrice = mutableStateOf(18250.0)
    val activeBubbles = mutableStateListOf<TradeBubble>()
    
    // Spoofing State
    var showSpoofAlert = mutableStateOf(false)
    var spoofPrice = mutableStateOf(0.0)

    fun triggerSpoofX(price: Double) {
        spoofPrice.value = price
        showSpoofAlert.value = true
        viewModelScope.launch {
            delay(800) // Das X leuchtet für 800ms auf
            showSpoofAlert.value = false
        }
    }

    fun updateOrderBook(price: Double, size: Int) {
        if (size <= 0) liveOrderBook.remove(price) 
        else liveOrderBook[price] = size
    }

    fun updatePrice(price: Double, size: Int) {
        currentPrice.value = price
        updateOrderBook(price, size)
    }

    fun addTrade(price: Double, size: Int, isBuy: Boolean) {
        activeBubbles.add(TradeBubble(price, size, isBuy))
        if (activeBubbles.size > 150) activeBubbles.removeAt(0)
    }
}
