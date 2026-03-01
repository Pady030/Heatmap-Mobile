package com.trading.heatmapmobile.engine

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf

class HeatmapEngine {
    // Das digitale Orderbuch: Preis -> Volumen
    val orderBook = mutableStateMapOf<Double, Int>()
    
    // Tracking für das kumulative Delta (Kauf- vs. Verkaufsdruck)
    var cumulativeDelta = mutableStateOf(0f)
    
    // Spoofing-Alarm Status
    var isSpoofingDetected = mutableStateOf(false)

    fun processOrderUpdate(price: Double, sizeBefore: Int, sizeAfter: Int, isTrade: Boolean) {
        val diff = sizeBefore - sizeAfter
        
        // 1. Spoofing Logik: Große Order verschwindet ohne Handel
        if (!isTrade && diff > 50) {
            isSpoofingDetected.value = true
        }

        // 2. Orderbuch aktualisieren
        if (sizeAfter <= 0) {
            orderBook.remove(price)
        } else {
            orderBook[price] = sizeAfter
        }
    }

    fun updateDelta(tradeSize: Int, isBuy: Boolean) {
        if (isBuy) cumulativeDelta.value += tradeSize
        else cumulativeDelta.value -= tradeSize
    }
}
