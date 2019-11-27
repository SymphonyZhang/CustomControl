package com.symphony.customcontrol

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun click(view: View){
        when(view){
            btn_check-> {
                cv.check()
            }
            btn_uncheck->{
                cv.unCheck()
            }
        }
    }
}
