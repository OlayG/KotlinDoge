package com.example.kotlindoge.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlindoge.R
import com.example.kotlindoge.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    private var msg = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        msg = arguments?.getString(MSG_KEY, "") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentBlankBinding.inflate(inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDisplay.text = msg
    }

    companion object {
        private const val MSG_KEY = "MSG_KEY"
        @JvmStatic
        fun newInstance(msg: String) = BlankFragment().apply {
            arguments = Bundle().apply { putString(MSG_KEY, msg) }
        }
    }
}