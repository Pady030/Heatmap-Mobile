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
    
    // Kernelemente der Trading-App
    private val engine = HeatmapEngine()
    private lateinit var hapticEngine: HapticEngine
    private val riskManager = RiskManager(maxDailyLoss = 1000.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hapticEngine = HapticEngine(this)

        setContent {
            val isSpoofing by engine.isSpoofingDetected
            val currentPnL by riskManager.currentPnL

            // Haupt-Layout (OLED-Optimiert)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
            ) {
                // 1. Heatmap & Orderflow Layer
                HeatmapRenderer(engine = engine)

                // 2. Risk Management (Oben)
                Column(
                    modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PnLPill(riskManager = riskManager)
                }

                // 3. Spoofing Warnung (Rechter Rand)
                Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                    SpoofIndicator(isVisible = isSpoofing)
                }

                // 4. Haptik-Logik: Feedback bei Marktereignissen
                LaunchedEffect(isSpoofing) {
                    if (isSpoofing) {
                        hapticEngine.triggerSpoofTick()
                        kotlinx.coroutines.delay(1000)
                        engine.isSpoofingDetected.value = false
                    }
                }
            }
        }
    }
}
