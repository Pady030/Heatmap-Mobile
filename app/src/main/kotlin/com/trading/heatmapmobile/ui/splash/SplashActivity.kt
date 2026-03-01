package com.trading.heatmapmobile.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trading.heatmapmobile.MainActivity
import com.trading.heatmapmobile.ui.theme.BuyNeon
import kotlinx.coroutines.*

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize().background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.Timeline, 
                        contentDescription = null, 
                        tint = BuyNeon, 
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        "HEATMAP MOBILE", 
                        color = BuyNeon, 
                        fontSize = 20.sp, 
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 4.sp
                    )
                }
            }
        }

        // Nach 1.5 Sekunden zur Haupt-App wechseln
        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}
