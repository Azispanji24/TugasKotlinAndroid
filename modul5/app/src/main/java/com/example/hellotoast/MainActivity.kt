package com.example.hellotoast

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloToastApp()
        }
    }
}

@Composable
fun HelloToastApp() {
    val context = LocalContext.current
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Angka
        Text(
            text = count.toString(),
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Row untuk tombol
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Tombol Toast
            Button(
                onClick = {
                    Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Toast", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Tombol Count
            Button(
                onClick = { count++ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Count", fontSize = 18.sp)
            }
        }
    }
}
