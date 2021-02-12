package com.example.kotlindoge.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindoge.R
import com.example.kotlindoge.databinding.ActivityExampleFragmentBinding
import com.example.kotlindoge.databinding.ActivityMainBinding

class ExampleFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExampleFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleFragmentBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, BlankFragment.newInstance("Hello from Example"), "BlankFragment")
            .commit()
    }

}