package com.trading.heatmapmobile.hardware

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.os.Build

class HapticManager(context: Context) {
    private val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    // 1. Scharfer Tick (Echter großer Trade)
    fun triggerTradeTick() {
        vibrator.vibrate(VibrationEffect.createOneShot(15, 180))
    }

    // 2. Doppeltes Warn-Ticken (Spoofing erkannt)
    fun triggerSpoofAlert() {
        val timings = longArrayOf(0, 20, 40, 20)
        val amplitudes = intArrayOf(0, 255, 0, 255)
        vibrator.vibrate(VibrationEffect.createWaveform(timings, amplitudes, -1))
    }

    // 3. Tiefes Pulsieren (Starke Delta-Divergenz)
    fun triggerDivergencePulse() {
        vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_DOUBLE_CLICK))
    }
}
