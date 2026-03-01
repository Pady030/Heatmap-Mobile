package com.trading.heatmapmobile.network

import android.util.Log
import com.trading.heatmapmobile.engine.HeatmapEngine

class RithmicConnector(private val engine: HeatmapEngine) {
    
    // Verbindungsparameter für Prop-Firmen
    private var isConnected = false
    private var currentProvider = "Apex/Bulenox"

    fun connect(user: String, pass: String, system: String = "Rithmic Paper Trading") {
        Log.d("Rithmic", "Connecting to $system for user $user...")
        
        // Simulation des Handshakes (Hier greift das Rithmic SDK ein)
        isConnected = true
        subscribeToMBO("NQ") 
    }

    private fun subscribeToMBO(symbol: String) {
        if (isConnected) {
            Log.d("Rithmic", "Subscribed to full MBO depth for $symbol")
            // In der Realität kommen hier die Protobuf-Datenpakete an
        }
    }

    // Diese Funktion füttert unsere HeatmapEngine mit Live-Daten
    fun onRawDataPacket(price: Double, sizeBefore: Int, sizeAfter: Int, isTrade: Boolean) {
        engine.processOrderUpdate(price, sizeBefore, sizeAfter, isTrade)
    }
}
