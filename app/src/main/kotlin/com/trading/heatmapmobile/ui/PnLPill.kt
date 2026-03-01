package com.trading.heatmapmobile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CapsuleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trading.heatmapmobile.risk.RiskManager

@Composable
fun PnLPill(riskManager: RiskManager) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .clip(CapsuleShape)
            .background(Color.DarkGray.copy(alpha = 0.8f))
            .padding(horizontal = 16.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$${riskManager.currentPnL.value}",
            color = riskManager.getPillColor(),
            fontSize = 14.sp
        )
    }
}
