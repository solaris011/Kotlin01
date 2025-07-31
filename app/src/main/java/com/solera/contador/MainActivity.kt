package com.solera.contador

import android.os.Bundle
import android.widget.Toast

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.solera.contador.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCharacters()
    }

        private fun getCharacters() {
            RetrofitClient.service.getCharacters().enqueue(object : Callback<CharacterResponse> {
                override fun onResponse(
                    call: Call<CharacterResponse>,
                    response: Response<CharacterResponse?>
                ) {
                    if (response.isSuccessful) {
                        val characters = response.body()?.results ?: emptyList()
                        binding.rvCharacters.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.rvCharacters.adapter = CharacterAdapter(characters)
                    }
                }

                override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error al obtener los personajes", Toast.LENGTH_LONG).show()
                }

            })
        }



//        viewModel.contador.observe(this) {
//                valor -> binding.textView.text = "$valor"
//
//        }
//
//        binding.btnSumar.setOnClickListener {
//            viewModel.incrementar()
//        }
//
//        binding.btnRestar.setOnClickListener {
//            viewModel.decrementar()
//        }
//
//        binding.btnReset.setOnClickListener {
//            viewModel.resetear()
//        }
    }
