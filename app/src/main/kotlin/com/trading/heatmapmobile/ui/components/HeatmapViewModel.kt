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

    init {
        // Die "Time-Travel" Engine: Bewegt Bubbles nach links
        viewModelScope.launch {
            while (true) {
                delay(16) // ~60 FPS Update-Rate für die Position
                val iterator = activeBubbles.iterator()
                while (iterator.hasNext()) {
                    val bubble = iterator.next()
                    bubble.xPosition -= 2f // Geschwindigkeit der Zeitachse
                    if (bubble.xPosition < 0) {
                        // Bubble ist aus dem Bildschirm gewandert
                    }
                }
            }
        }
    }

    fun addTrade(price: Double, size: Int, isBuy: Boolean) {
        activeBubbles.add(TradeBubble(price, size, isBuy))
        if (activeBubbles.size > 100) activeBubbles.removeAt(0) // Speicher schonen
    }
}
