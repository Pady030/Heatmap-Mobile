package com.trading.heatmapmobile.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import com.trading.heatmapmobile.ui.theme.*

@Composable
fun HeatmapCanvas(orderBook: Map<Double, Int>, currentPrice: Double) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        val rowHeight = 4f // Pixel pro Preis-Tick
        
        // 1. Gitter zeichnen (Subtiles Dunkelgrau)
        for (i in 0..height.toInt() step 40) {
            drawLine(
                color = GridGray,
                start = Offset(0f, i.toFloat()),
                end = Offset(width, i.toFloat()),
                strokeWidth = 1f
            )
        }

        // 2. Heatmap-Balken (Liquidität)
        orderBook.forEach { (price, size) ->
            // Relative Position zum aktuellen Preis berechnen
            val yOffset = (height / 2) + ((currentPrice - price).toFloat() * 10)
            
            if (yOffset in 0f..height) {
                val intensity = (size / 1000f).coerceIn(0.05f, 1f)
                drawRect(
                    color = BuyNeon.copy(alpha = intensity),
                    topLeft = Offset(0f, yOffset),
                    size = Size(width, rowHeight)
                )
            }
        }

        // 3. Aktuelle Preislinie (Zentral)
        drawLine(
            color = TextSilver,
            start = Offset(0f, height / 2),
            end = Offset(width, height / 2),
            strokeWidth = 2f
        )
    }
}
