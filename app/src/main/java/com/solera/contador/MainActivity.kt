package com.solera.contador

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import com.solera.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.contador.observe(this) {
                valor -> binding.textView.text = "$valor"

        }

        binding.btnSumar.setOnClickListener {
            viewModel.incrementar()
        }

        binding.btnRestar.setOnClickListener {
            viewModel.decrementar()
        }

        binding.btnReset.setOnClickListener {
            viewModel.resetear()
        }
    }
}