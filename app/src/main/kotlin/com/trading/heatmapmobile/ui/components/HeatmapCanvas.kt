package com.trading.heatmapmobile.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Fill
import com.trading.heatmapmobile.ui.theme.*

@Composable
fun HeatmapCanvas(viewModel: HeatmapViewModel) {
    val orderBook = viewModel.liveOrderBook
    val currentPrice = viewModel.currentPrice.value
    val bubbles = viewModel.activeBubbles

    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        // 1. Hintergrund-Liquidität (wie vorher)
        // ... (Logik bleibt gleich)

        // 2. Neon-Bubbles zeichnen
        bubbles.forEach { bubble ->
            val yOffset = (height / 2) + ((currentPrice - bubble.price).toFloat() * 10)
            
            if (yOffset in 0f..height) {
                drawCircle(
                    color = bubble.color.copy(alpha = (bubble.xPosition / width).coerceIn(0f, 0.7f)),
                    radius = bubble.radius,
                    center = Offset(bubble.xPosition, yOffset),
                    style = Fill
                )
            }
        }
    }
}
