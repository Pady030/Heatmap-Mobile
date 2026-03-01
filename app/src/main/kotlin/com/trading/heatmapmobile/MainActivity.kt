package com.trading.heatmapmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.trading.heatmapmobile.network.VaultManager
import com.trading.heatmapmobile.network.RithmicConnector
import com.trading.heatmapmobile.engine.HeatmapEngine

class MainActivity : ComponentActivity() {
    private val engine = HeatmapEngine()
    private lateinit var vault: VaultManager
    private lateinit var rithmic: RithmicConnector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vault = VaultManager(this)
        rithmic = RithmicConnector(engine)

        // Automatischer Login, falls Daten im Tresor sind
        val (user, pass) = vault.getCredentials()
        if (user != null && pass != null) {
            rithmic.connect(user, pass)
        }

        setContent {
            // Dein UI-Code bleibt hier erhalten...
        }
    }
}
