package com.trading.heatmapmobile.stats

data class SessionStats(
    val totalTrades: Int = 0,
    val winRate: Float = 0f,
    val netPnL: Double = 0.0,
    val maxDrawdown: Double = 0.0,
    val topTickCaught: Boolean = false,
    val rithmicEfficiency: Float = 0.98f // Latenz-Check
)
