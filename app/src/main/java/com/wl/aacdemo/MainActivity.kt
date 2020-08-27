package com.wl.aacdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wl.aacdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel
//          可以在.xml設定click事件
//        binding.btnRefresh.setOnClickListener { viewModel.refresh() }

        viewModel.mData.observe(this, {
                binding.txtHelloWord.text = it
                Toast.makeText(this, "下載完成", Toast.LENGTH_SHORT).show()
        })

    }
}