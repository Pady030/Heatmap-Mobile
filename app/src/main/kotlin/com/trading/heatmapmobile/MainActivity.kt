package com.trading.heatmapmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.trading.heatmapmobile.engine.HeatmapEngine
import com.trading.heatmapmobile.ui.HeatmapRenderer
import com.trading.heatmapmobile.ui.PnLPill
import com.trading.heatmapmobile.ui.SpoofIndicator
import com.trading.heatmapmobile.hardware.HapticEngine
import com.trading.heatmapmobile.risk.RiskManager

class MainActivity : ComponentActivity() {
    
    // Initialisierung der Kernelemente
    private val engine = HeatmapEngine()
    private lateinit var hapticEngine: HapticEngine
    private val riskManager = RiskManager(maxDailyLoss = 1000.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hapticEngine = HapticEngine(this)

        setContent {
            // State-Tracking für die UI-Reaktivität
            val isSpoofing by engine.isSpoofingDetected
            val currentPnL by riskManager.currentPnL

            // Haupt-Layout: Deep Black OLED Background
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
            ) {
                // 1. Die Heatmap & 3D Bubbles Layer
                HeatmapRenderer(engine = engine)

                // 2. Risk Management Center (Oben)
                Column(
                    modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PnLPill(riskManager = riskManager)
                }

                // 3. Spoofing Warn-Indikator (Zentral/Rechts)
                Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                    SpoofIndicator(isVisible = isSpoofing)
                }

                // 4. Haptik-Trigger-Logik (Side Effect)
                LaunchedEffect(isSpoofing) {
                    if (isSpoofing) {
                        hapticEngine.triggerSpoofTick()
                        // Reset nach Kurzer Zeit
                        kotlinx.coroutines.delay(1000)
                        engine.isSpoofingDetected.value = false
                    }
                }
            }
        }
    }
}
