package com.example.retrofitdependencinjection.presentation.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdependencinjection.databinding.ActivityMainBinding
import com.example.retrofitdependencinjection.presentation.viewmodel.CharactersViewModel
import com.example.retrofitdependencinjection.presentation.views.adapter.CharacterListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var charactersViewModel: CharactersViewModel
    private lateinit var characterListAdapter: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        charactersViewModel = ViewModelProvider(this)[CharactersViewModel::class.java]

        setDataToAdapter()
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
            characterListAdapter.setCharacterData(it)
           // _binding.textView.text = it.toString()
        }

    }

    private fun setDataToAdapter(){
        characterListAdapter = CharacterListAdapter()
        _binding.recyclerView.adapter = characterListAdapter
        _binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}