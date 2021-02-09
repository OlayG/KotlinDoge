package com.example.kotlindoge.view

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.kotlindoge.R
import com.example.kotlindoge.databinding.ActivityMainBinding
import com.example.kotlindoge.viewmodel.MainViewModel

/**
 * Classes
 * instead of `extends` we use `:`
 * instead of `implements` we use `,`
 *
 *
 *
 * AccessModifer - public, private, etc
 * Java method declaration: [AccessModifer] [ReturnType] [Name]
 *                     ex: private AppCompactActivity methodName()
 * Kotlin method declaration: [AccessModifer] [Name] : [ReturnType]
 *                     ex: private fun methodName() : AppCompactActivity
 *
 *
 *
 * Kotlin
 *  - NON-NULL by default ( [TYPE]? ) -> add ? at end of Type Class to enable it nullability)
 *  - class are final by default
 *
 * Java
 *  - NULL by default
 *  - class are final by default
 */
class MainActivity : AppCompatActivity() {
    // leverages lazy and extension functions to create viwemodel
    private val viewModel by viewModels<MainViewModel>()

    // In kotlin declarations must have a default value
    // To be able to create a Top-Level Declaration with no init value we use [lateinit]
    // contract with compiler that says we promise to initialize this variable before we use it
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        viewModel.doges.observe(this) { dogeList ->
            Toast.makeText(this, "List size is ${dogeList.size}", Toast.LENGTH_SHORT).show()
        }

        binding.tvDisplay.text = "Zaboomafooo"

        binding.tvDisplay.apply {
            isAllCaps = true
            textSize = 40f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
        }


       with(binding.tvDisplay) {
            isAllCaps = true
            textSize = 40f
        }


    }

}