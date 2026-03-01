package com.trading.heatmapmobile.hardware

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

class HapticEngine(context: Context) {
    private val vibrator = if (android.os.Build.VERSION.SDK_INT >= 31) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    // 1. Kurzes Ticken für Spoofing (wie ein mechanisches Klicken)
    fun triggerSpoofTick() {
        vibrator.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE))
    }

    // 2. Raues Muster für Delta-Divergenz (Warnung!)
    fun triggerDivergenceAlert() {
        val timings = longArrayOf(0, 40, 80, 40)
        val amplitudes = intArrayOf(0, 255, 0, 255)
        vibrator.vibrate(VibrationEffect.createWaveform(timings, amplitudes, -1))
    }

    // 3. Sanftes Pulsieren bei hohen Iceberg-Volumen
    fun triggerIcebergPulse() {
        vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_DOUBLE_CLICK))
    }
}
