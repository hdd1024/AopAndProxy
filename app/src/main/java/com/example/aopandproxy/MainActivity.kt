package com.example.aopandproxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aop_library.annotation.NetWorkState

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toNetWork()
    }

    @NetWorkState(hint = "哈哈哈哈哈哈哈!没有网络了！")
    fun toNetWork() {

    }
}
