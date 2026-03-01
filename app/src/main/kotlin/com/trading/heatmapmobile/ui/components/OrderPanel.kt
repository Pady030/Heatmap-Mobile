package com.trading.heatmapmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trading.heatmapmobile.ui.theme.*

@Composable
fun PnLPill(pnl: Double) {
    val color = if (pnl >= 0) BuyNeon else SellNeon
    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(50))
            .background(color.copy(alpha = 0.2f))
            .padding(horizontal = 20.dp, vertical = 4.dp)
    ) {
        Text(
            text = "$${String.format("%.2f", pnl)}",
            color = color,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun OrderPanel(onBuy: () -> Unit, onSell: () -> Unit, onFlatten: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onBuy, colors = ButtonDefaults.buttonColors(backgroundColor = BuyNeon)) {
            Text("BUY", color = Color.Black, fontWeight = FontWeight.Bold)
        }
        Button(onClick = onFlatten, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
            Text("FLATTEN", color = Color.Black, fontWeight = FontWeight.Bold)
        }
        Button(onClick = onSell, colors = ButtonDefaults.buttonColors(backgroundColor = SellNeon)) {
            Text("SELL", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}
