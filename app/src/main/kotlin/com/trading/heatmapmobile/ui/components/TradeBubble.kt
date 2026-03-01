package com.trading.heatmapmobile.ui.components

import androidx.compose.ui.graphics.Color

data class TradeBubble(
    val price: Double,
    val size: Int,
    val isBuy: Boolean,
    var xPosition: Float = 1000f, // Startet ganz rechts
    val timestamp: Long = System.currentTimeMillis()
) {
    val color: Color = if (isBuy) Color(0xFF00F5FF) else Color(0xFFFF00FF)
    val radius: Float = (size.toFloat() * 2f).coerceIn(5f, 50f) // Größe basierend auf Volumen
}
