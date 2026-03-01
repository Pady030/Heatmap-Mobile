package com.trading.heatmapmobile.ui.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.trading.heatmapmobile.stats.SessionStats

class HeatmapViewModel : ViewModel() {
    // ... (vorheriger Code bleibt erhalten)
    
    var isStatsVisible = mutableStateOf(false)
    var currentSessionStats = mutableStateOf(SessionStats())

    fun toggleStats() {
        isStatsVisible.value = !isStatsVisible.value
    }
}
