package com.example.test

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.ui.theme.TestTheme
import java.util.logging.LoggingMXBean

class MainActivity : ComponentActivity() {
    private val TAG = "My App"

    private var timeOnCreate: Long = 0
    private var timeOnStart: Long = 0
    private var timeOnResume: Long = 0
    private var timeOnPause: Long = 0
    private var timeOnStop: Long = 0
    private var timeOnDestroy: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "Activity Created")
        enableEdgeToEdge()
        setContentView(R.layout.main_activity);


        val myButton: Button = findViewById(R.id.mybutton)

        myButton.setOnClickListener {
            Log.i(TAG, "Кнопка нажата!")
            Toast.makeText(this, "Кнопка нажата!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()

        timeOnStart = System.currentTimeMillis()
        Log.d("Lifecycle", "onStart: $timeOnStart (різниця: ${timeOnStart - timeOnCreate} мс)")
    }

    override fun onResume() {
        super.onResume()

        timeOnResume = System.currentTimeMillis()
        Log.d("Lifecycle", "onResume: $timeOnResume (різниця: ${timeOnResume - timeOnStart} мс)")
    }

    override fun onPause() {
        super.onPause()

        timeOnPause = System.currentTimeMillis()
        Log.d("Lifecycle", "onPause: $timeOnPause (різниця: ${timeOnPause - timeOnResume} мс)")
    }

    override fun onStop() {
        super.onStop()

        timeOnStop = System.currentTimeMillis()
        Log.d("Lifecycle", "onStop: $timeOnStop (різниця: ${timeOnStop - timeOnPause} мс)")
    }

    override fun onDestroy() {
        super.onDestroy()

        timeOnDestroy = System.currentTimeMillis()
        Log.d("Lifecycle", "onDestroy: $timeOnDestroy (різниця: ${timeOnDestroy - timeOnStop} мс)")
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Greeting("Android")
    }
}