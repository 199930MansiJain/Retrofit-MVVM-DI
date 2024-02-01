package com.example.retrofitdependencinjection.presentation.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdependencinjection.databinding.ActivityMainBinding
import com.example.retrofitdependencinjection.presentation.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var charactersViewModel: CharactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        charactersViewModel = ViewModelProvider(this)[CharactersViewModel::class.java]

        fetchData(charactersViewModel)
    }

    private fun fetchData(charactersViewModel: CharactersViewModel) {
        charactersViewModel.errorMsg.observe(this){
           Toast.makeText(this,"error Loading Data",Toast.LENGTH_LONG).show()
        }
        charactersViewModel.isLoading.observe(this){
            Toast.makeText(this,"Loading Data",Toast.LENGTH_LONG).show()
        }
        charactersViewModel.response.observe(this){
            _binding.textView.text = it.toString()
        }

    }
}