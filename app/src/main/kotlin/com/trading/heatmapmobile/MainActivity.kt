package com.trading.heatmapmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/* * HEATMAP MOBILE v1.2 
 * Core Engine for S25 Slim
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)) {
                Text(
                    text = "HEATMAP MOBILE ENGINE ACTIVE",
                    color = Color.Cyan,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}
