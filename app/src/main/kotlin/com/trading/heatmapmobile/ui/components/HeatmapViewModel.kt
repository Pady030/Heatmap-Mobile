package com.trading.heatmapmobile.ui.components

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.trading.heatmapmobile.hardware.HapticManager

class HeatmapViewModel(private val hapticManager: HapticManager? = null) : ViewModel() {
    val liveOrderBook = mutableStateMapOf<Double, Int>()
    val currentPrice = mutableStateOf(18250.0)
    val activeBubbles = mutableStateListOf<TradeBubble>()
    var showSpoofAlert = mutableStateOf(false)

    fun triggerSpoofX(price: Double) {
        showSpoofAlert.value = true
        hapticManager?.triggerSpoofAlert() // SPÜRE die Falle!
        // Reset Logik...
    }

    fun addTrade(price: Double, size: Int, isBuy: Boolean) {
        if (size > 100) hapticManager?.triggerTradeTick() // SPÜRE den Wal!
        activeBubbles.add(TradeBubble(price, size, isBuy))
    }
}
