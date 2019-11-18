package com.symphony.customcontrol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.symphony.customcontrol.entities.PieData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var datas = ArrayList<PieData>()
        val pieData1 = PieData("hey",60f)
        val pieData2 = PieData("hey",30f)
        val pieData3 = PieData("hey",40f)
        val pieData4 = PieData("hey",20f)
        val pieData5 = PieData("hey",20f)
        datas.add(pieData1)
        datas.add(pieData2)
        datas.add(pieData3)
        datas.add(pieData4)
        datas.add(pieData5)
        pieView.setData(datas)
    }
}
