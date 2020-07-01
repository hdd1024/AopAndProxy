package com.example.aopandproxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aop_library.annotation.NetWorkState;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        TestN testN = new TestN();
//        testN.testNetWork();
        testA();
    }

    @NetWorkState
    public void testA(){

    }

}
