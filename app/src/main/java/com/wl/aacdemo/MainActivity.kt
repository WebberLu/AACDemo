package com.wl.aacdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wl.aacdemo.ui.RepoFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tag: String = RepoFragment.TAG

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            val fragment = RepoFragment.newInstance()
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, it, tag)
                    .commit()
            }
        }
    }
}