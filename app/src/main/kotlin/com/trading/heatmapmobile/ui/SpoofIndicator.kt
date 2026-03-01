package com.trading.heatmapmobile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SpoofIndicator(isVisible: Boolean) {
    if (isVisible) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "X",
                color = Color(0xFFFFAB40), // Neon Orange
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
