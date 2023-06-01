package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.pak_001,
        R.drawable.pak_002,
        R.drawable.pak_003,
        R.drawable.pak_004,
        R.drawable.pak_005,
        R.drawable.pak_006,
        R.drawable.pak_007,
        R.drawable.pak_008,
        R.drawable.pak_009,
        R.drawable.pak_010,
    )
    private val nameIdList = listOf(
        "Bulbasaur",
        "Ivysaur",
        "Venusaur",
        "Charmander",
        "Charmeleon",
        "Charizard",
        "Squirtle",
        "Wartortle",
        "Blastoise",
        "Caterpie",
    )
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            btnAdd.setOnClickListener {
                if (index > 9) index = 0
                var plant = Plant(imageIdList[index], nameIdList[index])
                adapter.addPlant(plant)
                index++
            }
        }
    }
}