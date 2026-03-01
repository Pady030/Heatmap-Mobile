package com.trading.heatmapmobile.risk

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

class RiskManager(private val maxDailyLoss: Double) {
    var currentPnL = mutableStateOf(0.0)
    var isAccountLocked = mutableStateOf(false)

    fun updatePnL(newPnL: Double) {
        currentPnL.value = newPnL
        
        // Wenn der Verlust das Limit erreicht: "Emergency Lock"
        if (currentPnL.value <= -maxDailyLoss) {
            isAccountLocked.value = true
        }
    }

    fun getPillColor(): Color {
        return when {
            currentPnL.value >= 0 -> Color(0xFF00E676) // Giftgrün für Profit
            currentPnL.value > -maxDailyLoss * 0.7 -> Color.White // Neutral
            else -> Color(0xFFFF1744) // Hellrot bei drohendem Limit
        }
    }
}
