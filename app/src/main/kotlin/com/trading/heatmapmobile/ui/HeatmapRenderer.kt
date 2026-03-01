package com.trading.heatmapmobile.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.trading.heatmapmobile.engine.HeatmapEngine

@Composable
fun HeatmapRenderer(engine: HeatmapEngine) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // 1. Zeichne die Heatmap (Hintergrund-Liquidität)
        engine.orderBook.forEach { (price, size) ->
            val y = priceToY(price) // Hilfsfunktion für Skalierung
            val intensity = (size / 500f).coerceIn(0.1f, 1f)
            
            drawRect(
                color = Color.Cyan.copy(alpha = intensity),
                topLeft = Offset(0f, y),
                size = Size(size.toFloat() * 2, 2f)
            )
        }

        // 2. Zeichne den "Market Pulse" Glow (Momentum)
        drawMarketPulseGlow(engine.cumulativeDelta.value)
    }
}

private fun DrawScope.drawMarketPulseGlow(delta: Float) {
    val pulseColor = if (delta >= 0) Color.Cyan else Color.Magenta
    // Neon-Effekt am rechten Rand
    drawRect(
        color = pulseColor.copy(alpha = 0.3f),
        topLeft = Offset(size.width - 10f, 0f),
        size = Size(10f, size.height)
    )
}

private fun priceToY(price: Double): Float {
    // Einfache Skalierung (wird in der Final-Version dynamisch)
    return (price % 100).toFloat() * 10f
}
