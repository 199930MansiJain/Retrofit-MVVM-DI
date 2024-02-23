package com.example.retrofitdependencinjection.presentation.views.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdependencinjection.R
import com.example.retrofitdependencinjection.core.utils.loadSvg
import com.example.retrofitdependencinjection.databinding.CharacterListAdapterBinding
import com.example.retrofitdependencinjection.domain.model.Character
import java.util.Locale

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {

    private var getCharacterDataList: MutableList<Character> = mutableListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun setCharacterData(characterDataList: List<Character>?) {
        getCharacterDataList = characterDataList as MutableList<Character>
        notifyDataSetChanged()
    }

    inner class CharacterListViewHolder(val binding: CharacterListAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //binding Adapter data with UI elements
        fun bind(character: Character) {
            binding.imageView.loadSvg(character.image, R.drawable.ic_launcher_background)
            binding.userName.text =
                character.name.lowercase(Locale.getDefault())
                    .replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.ROOT
                        ) else it.toString()
                    }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val binding =
            CharacterListAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CharacterListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return getCharacterDataList.size
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(getCharacterDataList[position])
    }
}