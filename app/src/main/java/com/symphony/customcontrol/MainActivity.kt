package com.symphony.customcontrol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.symphony.customcontrol.view.TestView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val testView = TestView(this@MainActivity)
        setContentView(testView)

    }
}
