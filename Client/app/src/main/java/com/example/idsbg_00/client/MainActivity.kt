package com.example.idsbg_00.client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener({
            //启动测试
            val macAddress = Util.getRandomMacAddress()
            val client = Client(macAddress)
            client.start()
        })
    }
}
