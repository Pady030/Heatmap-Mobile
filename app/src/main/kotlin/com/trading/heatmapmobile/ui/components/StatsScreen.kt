package com.trading.heatmapmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trading.heatmapmobile.ui.theme.*

@Composable
fun StatsScreen(stats: com.trading.heatmapmobile.stats.SessionStats) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.9f))
            .padding(24.dp)
    ) {
        Text("SESSION SUMMARY", color = BuyNeon, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(20.dp))

        StatRow("Net P&L", "$${stats.netPnL}", if (stats.netPnL >= 0) BuyNeon else SellNeon)
        StatRow("Win Rate", "${(stats.winRate * 100).toInt()}%", TextSilver)
        StatRow("Max Drawdown", "$${stats.maxDrawdown}", SellNeon)
        StatRow("Total Trades", "${stats.totalTrades}", TextSilver)
        
        Spacer(modifier = Modifier.weight(1f))
        
        Text(
            "Prop-Firm Status: ${if (stats.maxDrawdown < 2500) "✅ QUALIFIED" else "❌ FAILED"}",
            color = if (stats.maxDrawdown < 2500) Color.Green else Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StatRow(label: String, value: String, valueColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = TextSilver.copy(alpha = 0.6f), fontSize = 16.sp)
        Text(value, color = valueColor, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}
