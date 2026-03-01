package com.trading.heatmapmobile.engine

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

data class TradeBubble(
    val price: Double,
    val size: Int,
    val timestamp: Long,
    val color: Color,
    var positionX: Float = 0f // Wandert von rechts nach links
)
